package com.example.reservespace3.service;

import com.example.reservespace3.model.Space;
import com.example.reservespace3.model.SpaceType;

import java.util.List;
import java.util.Optional;

public interface SpaceService {
    Optional<Space> findById(Long id);
    List<Space> findAll();
    void deleteById(Long id);
    Optional<Space> edit(Long id, String name, String address, SpaceType type, String url);
    Optional<Space> save(String name, String address, SpaceType type, String url);
}
