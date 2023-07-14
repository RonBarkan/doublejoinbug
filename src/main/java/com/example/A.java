package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import jakarta.annotation.Nullable;
import jakarta.persistence.Table;

import java.util.List;

@Introspected
@Table(schema = "my_schema")
@MappedEntity("a")
public class A {
  @Id
  @GeneratedValue
  public Long aId;

  public String name;

  @Relation(Relation.Kind.ONE_TO_MANY)
  @Nullable
  public List<B> b;

  @Relation(Relation.Kind.ONE_TO_MANY)
  @Nullable
  public List<C> c;

  public Long getAId() {
    return aId;
  }

  public void setAId(Long aId) {
    this.aId = aId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Nullable
  public List<B> getB() {
    return b;
  }

  public void setB(@Nullable List<B> b) {
    this.b = b;
  }

  @Nullable
  public List<C> getC() {
    return c;
  }

  public void setC(@Nullable List<C> c) {
    this.c = c;
  }
}
