package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.Table;

@Introspected
@Table(schema = "my_schema")
@MappedEntity("c")
public class C {
  @Id
  @GeneratedValue
  Long cId;
  Long aId;
  String cProp;

  public Long getCId() {
    return cId;
  }

  public void setCId(Long cId) {
    this.cId = cId;
  }

  public Long getAId() {
    return aId;
  }

  public void setAId(Long aId) {
    this.aId = aId;
  }

  public String getCProp() {
    return cProp;
  }

  public void setCProp(String cProp) {
    this.cProp = cProp;
  }
}
