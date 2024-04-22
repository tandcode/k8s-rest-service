package com.example.restservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public final class Greeting {
  @Id
  @GeneratedValue
  private long id;
  private String content;

  public Greeting(String content) {
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Greeting) obj;
    return this.id == that.id &&
        Objects.equals(this.content, that.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, content);
  }

  @Override
  public String toString() {
    return "Greeting[" +
        "id=" + id + ", " +
        "content=" + content + ']';
  }
}
