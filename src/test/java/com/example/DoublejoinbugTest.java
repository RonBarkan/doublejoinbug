package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.List;

@MicronautTest(transactional = false)
class DoublejoinbugTest {

    @Inject
    EmbeddedApplication<?> application;
    @Inject ATable aTable;
    @Inject BTable bTable;
    @Inject CTable cTable;

    @BeforeEach
    void wipeTables() {
      cTable.deleteAll();
      bTable.deleteAll();
      aTable.deleteAll();
    }

    @Test
    void testItWorks() {
      Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testDoubleJoin() {
      A a = new A();
      a.setName("a1");
      a = aTable.save(a);

      C c1 = new C();
      c1.setAId(a.getAId());
      c1.setCProp("c1");
      cTable.save(c1);

      B b1 = new B();
      b1.setAId(a.getAId());
      b1.setBProp("b1");
      b1.setReqProp("c1");
      bTable.save(b1);

      B b2 = new B();
      b2.setAId(a.getAId());
      b2.setBProp("b2");
      bTable.save(b2);

      List<A> as = aTable.findNPE(a.getAId());  // Currently, this will throw NPE
      Assertions.assertEquals(1, as.size());
      Assertions.assertEquals(2, as.get(0).b.size());
      Assertions.assertEquals(1, as.get(0).c.size());

      as = aTable.findIgnoreC(a.getAId());  // Currently, this will completely ignore C column
      Assertions.assertEquals(1, as.size());
      Assertions.assertEquals(2, as.get(0).b.size());
      Assertions.assertEquals(1, as.get(0).c.size());
    }
}
