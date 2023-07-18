package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.jdbc.annotation.JoinColumn;
import jakarta.annotation.Nullable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Introspected
@Table(schema = "my_schema")
@MappedEntity("e")
public class E {
  @Id
  @GeneratedValue
  Long id;
  long catId;
  long eId;
  String name;
  @OneToMany
  @JoinColumn(name = "e_id", referencedColumnName = "e_id")
  @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
  List<F> f;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Nullable
  public List<F> getF() {
    return f;
  }

  public void setF(@Nullable List<F> f) {
    this.f = f;
  }

  public long getEId() {
    return eId;
  }

  public void setEId(long eId) {
    this.eId = eId;
  }
}
