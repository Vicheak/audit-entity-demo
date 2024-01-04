package com.vicheak.auditentitydemo.repository;

import com.vicheak.auditentitydemo.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Integer> {



}
