package com.example.reservespace3.service.impl;

import com.example.reservespace3.model.Space;
import com.example.reservespace3.model.SpaceType;
import com.example.reservespace3.model.exceptions.SpaceNotFoundException;
import com.example.reservespace3.repository.CityRepository;
import com.example.reservespace3.repository.SpaceRepository;
import com.example.reservespace3.service.SpaceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;
    private final CityRepository cityRepository;

    public SpaceServiceImpl(SpaceRepository spaceRepository, CityRepository cityRepository) {
        this.spaceRepository = spaceRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Optional<Space> findById(Long id) {
        return this.spaceRepository.findById(id);
    }

    @Override
    public List<Space> findAll() {
        return this.spaceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.spaceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Space> edit(Long id, String name, String address, SpaceType type, String url) {
        Space space = this.spaceRepository.findById(id).orElseThrow(() -> new SpaceNotFoundException(id));

        space.setName(name);
        space.setSpaceType(type);
        space.setAddress(address);
        space.setUrl(url);

        return Optional.of(this.spaceRepository.save(space));
    }

    @Override
    @Transactional
    public Optional<Space> save(String name, String address, SpaceType type, String url) {
        return Optional.of(this.spaceRepository.save(new Space(name, address, type, url)));
    }
}
