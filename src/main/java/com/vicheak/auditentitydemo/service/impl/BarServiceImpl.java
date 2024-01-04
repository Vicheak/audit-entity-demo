package com.vicheak.auditentitydemo.service.impl;

import com.vicheak.auditentitydemo.entity.Bar;
import com.vicheak.auditentitydemo.repository.BarRepository;
import com.vicheak.auditentitydemo.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarServiceImpl implements BarService {

    private final BarRepository barRepository;

    @Override
    public List<Bar> loadAllBars() {
        return barRepository.findAll();
    }

    @Override
    public Bar loadBarById(Integer id) {
        return barRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Bar not found!")
                );
    }

    @Override
    public void createNewBar(Bar newBar) {
        barRepository.save(newBar);
    }

    @Override
    public void updateBarById(Integer id, Bar updateBar) {
        Bar bar = barRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Bar not found!")
                );

        bar.setName(updateBar.getName());
        barRepository.save(bar);
    }

    @Override
    public void deleteBarById(Integer id) {
        barRepository.deleteById(id);
    }

}
