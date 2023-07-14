package com.example;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class ATable implements CrudRepository<A, Long> {

  @Query("""
    Select
      a.a_id,
      a.name,
      b.b_id b_b_id,
      b.a_id b_a_id,
      b.b_prop b_b_prop,
      b.req_prop b_req_prop,
      c.c_id c_c_id,
      c.a_id c_a_id,
      c.c_prop c_c_prop
    From my_schema.a
    LEFT JOIN my_schema.b on a.a_id=b.a_id
    LEFT JOIN my_schema.c on a.a_id=c.a_id and b.req_prop=c.c_prop
    WHERE a.a_id=:aId
    ORDER BY a.a_id,b.b_id,c.c_id
  """)
  @Join(value = "b", alias = "b_")
  @Join(value = "c", alias = "c_")
  abstract List<A> findBlah(long aId);
}
