package com.example.reservespace3.service;

import com.example.reservespace3.model.City;

import java.util.List;

public interface CityService {
    City create(String name);
    City update(String name);
    void delete(String name);
    List<City> listCities();
}
