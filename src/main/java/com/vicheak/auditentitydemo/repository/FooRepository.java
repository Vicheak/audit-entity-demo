package com.vicheak.auditentitydemo.repository;

import com.vicheak.auditentitydemo.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Integer> {



}
