package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.Table;

@Introspected
@Table(schema = "my_schema")
@MappedEntity("f")
public class F {
  @Id
  @GeneratedValue
  Long id;
  long eId;
  long catId;
  String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getEId() {
    return eId;
  }

  public void setEId(long eId) {
    this.eId = eId;
  }

  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
