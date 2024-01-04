package com.vicheak.auditentitydemo.controller;

import com.vicheak.auditentitydemo.entity.Bar;
import com.vicheak.auditentitydemo.entity.Foo;
import com.vicheak.auditentitydemo.service.FooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foos")
@RequiredArgsConstructor
public class FooController {

    private final FooService fooService;

    @GetMapping
    public List<Foo> loadAllFoos(){
        return fooService.loadAllFoos();
    }

    @GetMapping("/{id}")
    public Foo loadFooById(@PathVariable Integer id){
        return fooService.loadFooById(id);
    }

    @PostMapping
    public void createNewFoo(@RequestBody Foo foo){
        fooService.createNewFoo(foo);
    }

    @PutMapping("/{id}")
    public void updateFooById(@PathVariable Integer id,
                              @RequestBody Foo foo){
        fooService.updateFooById(id, foo);
    }

    @DeleteMapping("/{id}")
    public void deleteFooById(@PathVariable Integer id){
        fooService.deleteFooById(id);
    }

}
