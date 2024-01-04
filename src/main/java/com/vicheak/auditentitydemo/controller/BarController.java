package com.vicheak.auditentitydemo.controller;

import com.vicheak.auditentitydemo.entity.Bar;
import com.vicheak.auditentitydemo.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bars")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;

    @GetMapping
    public List<Bar> loadAllBars(){
        return barService.loadAllBars();
    }

    @GetMapping("/{id}")
    public Bar loadBarById(@PathVariable Integer id){
        return barService.loadBarById(id);
    }

    @PostMapping
    public void createNewBar(@RequestBody Bar bar){
        barService.createNewBar(bar);
    }

    @PutMapping("/{id}")
    public void updateBarById(@PathVariable Integer id,
                              @RequestBody Bar bar){
        barService.updateBarById(id, bar);
    }

    @DeleteMapping("/{id}")
    public void deleteBarById(@PathVariable Integer id){
        barService.deleteBarById(id);
    }

}
