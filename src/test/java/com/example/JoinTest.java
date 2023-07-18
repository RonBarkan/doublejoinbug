package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@MicronautTest(transactional = false)
class JoinTest {

  @Inject ETable eTable;
  @Inject FTable fTable;

  @BeforeEach
  void wipeTables() {
    fTable.deleteAll();
    eTable.deleteAll();
  }

  @Test
  void testJoin() {
    F f = new F();
    f.setCatId(7);
    f.setEId(11);
    f.setName("f1");
    fTable.save(f);

    f = new F();
    f.setCatId(7);
    f.setEId(11);
    f.setName("f2");
    fTable.save(f);

    E e = new E();
    e.setCatId(7);
    e.setEId(11);
    e.setName("e1");
    eTable.save(e);

    e = new E();
    e.setCatId(7);
    e.setEId(13);
    e.setName("e2");
    eTable.save(e);

    List<E> es = eTable.findByCatId(7);
    Assertions.assertEquals(2, es.size());
  }
}
