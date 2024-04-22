#!/usr/bin/env bash
#docker image build --progress=plain -t rest-service/jar:latest -f Dockerfile-jar .
docker image build --progress=plain -t rest-service/native:latest -f Dockerfile-native .
