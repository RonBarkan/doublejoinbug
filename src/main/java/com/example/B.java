package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import jakarta.persistence.Table;

@Introspected
@Table(schema = "my_schema")
@MappedEntity("b")
public class B {
  @Id
  @GeneratedValue
  Long bId;
  Long aId;
  String bProp;
  @Nullable
  String reqProp;

  public Long getBId() {
    return bId;
  }

  public void setBId(Long bId) {
    this.bId = bId;
  }

  public Long getAId() {
    return aId;
  }

  public void setAId(Long aId) {
    this.aId = aId;
  }

  public String getBProp() {
    return bProp;
  }

  public void setBProp(String bProp) {
    this.bProp = bProp;
  }

  public String getReqProp() {
    return reqProp;
  }

  public void setReqProp(String reqProp) {
    this.reqProp = reqProp;
  }
}
