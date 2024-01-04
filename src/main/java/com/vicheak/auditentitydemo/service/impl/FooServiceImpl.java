package com.vicheak.auditentitydemo.service.impl;

import com.vicheak.auditentitydemo.entity.Foo;
import com.vicheak.auditentitydemo.repository.FooRepository;
import com.vicheak.auditentitydemo.service.FooService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FooServiceImpl implements FooService {

    private final FooRepository fooRepository;

    @Override
    public List<Foo> loadAllFoos() {
        return fooRepository.findAll();
    }

    @Override
    public Foo loadFooById(Integer id) {
        return fooRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Foo not found!")
                );
    }

    @Override
    public void createNewFoo(Foo newFoo) {
        fooRepository.save(newFoo);
    }

    @Override
    public void updateFooById(Integer id, Foo updateFoo) {
        Foo foo = fooRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Foo not found!")
                );

        foo.setName(updateFoo.getName());
        foo.setBar(updateFoo.getBar());
        fooRepository.save(foo);
    }

    @Override
    public void deleteFooById(Integer id) {
        fooRepository.deleteById(id);
    }

}
