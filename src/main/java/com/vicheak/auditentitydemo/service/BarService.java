package com.vicheak.auditentitydemo.service;

import com.vicheak.auditentitydemo.entity.Bar;

import java.util.List;

public interface BarService {

    List<Bar> loadAllBars();

    Bar loadBarById(Integer id);

    void createNewBar(Bar newBar);

    void updateBarById(Integer id, Bar updateBar);

    void deleteBarById(Integer id);

}
