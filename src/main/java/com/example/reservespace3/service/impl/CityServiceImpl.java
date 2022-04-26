package com.example.reservespace3.service.impl;

import com.example.reservespace3.model.City;
import com.example.reservespace3.repository.CityRepository;
import com.example.reservespace3.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(String name) {
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException();
        City c = new City(name);
        cityRepository.save(c);
        return c;
    }

    @Override
    public City update(String name) {
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException();
        City c = this.cityRepository.findByName(name);
        cityRepository.save(c);
        return c;
    }

    @Override
    public void delete(String name) {
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException();
        cityRepository.deleteByName(name);
    }

    @Override
    public List<City> listCities() {
        return this.cityRepository.findAll();
    }
}
