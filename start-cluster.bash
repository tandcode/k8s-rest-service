#!/usr/bin/env bash

# choose image type: jar or native
# TODO: native is not working as of now, to be fixed
SUFFIX="jar"
if [ "$1" == "-n" ]; then
    SUFFIX="native"
fi

IMAGE_TAG=rest-service/$SUFFIX:latest
# build image
docker image build --progress=plain -t $IMAGE_TAG -f docker/Dockerfile-$SUFFIX .

# stop cluster if running
kind delete cluster
# start with open 30070 port
kind create cluster --config=k8s/kind.yml
# load built image to cluster
kind load docker-image $IMAGE_TAG
# apply k8s infrastructure
kubectl apply -f k8s/postgres-configmap.yml
kubectl apply -f k8s/secrets.yml
kubectl apply -f k8s/postgres-deployment.yml
kubectl apply -f k8s/app-deployment.yml
# update image name
kubectl set image deployment/rest-app-spring rest-app-spring=$IMAGE_TAG

echo "wait for a minute for cluster to spin up"; sleep 60
# healthcheck
curl http://localhost:30070/greeting -H "Accept: application/json"; echo ""
