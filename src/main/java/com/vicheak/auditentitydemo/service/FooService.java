package com.vicheak.auditentitydemo.service;

import com.vicheak.auditentitydemo.entity.Foo;

import java.util.List;

public interface FooService {

    List<Foo> loadAllFoos();

    Foo loadFooById(Integer id);

    void createNewFoo(Foo newFoo);

    void updateFooById(Integer id, Foo updateFoo);

    void deleteFooById(Integer id);

}
