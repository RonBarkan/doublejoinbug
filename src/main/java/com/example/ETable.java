package com.example;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Where;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class ETable implements CrudRepository<E, Long> {

  @Join(value = "f", alias = "f_", type = Join.Type.LEFT_FETCH)
  @Where("@.cat_id = :catId")
  public abstract List<E> findByCatId(long catId);
}