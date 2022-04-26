package com.example.reservespace3.service.impl;

import com.example.reservespace3.model.Space;
import com.example.reservespace3.model.User;
import com.example.reservespace3.model.UserReservedSpaces;
import com.example.reservespace3.model.exceptions.SpaceExistsException;
import com.example.reservespace3.model.exceptions.SpaceNotFoundException;
import com.example.reservespace3.model.exceptions.UserSpacesNotFound;
import com.example.reservespace3.repository.UserRepository;
import com.example.reservespace3.repository.UserSpacesRepository;
import com.example.reservespace3.service.SpaceService;
import com.example.reservespace3.service.UserSpacesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSpacesServiceImpl implements UserSpacesService {

    private final UserSpacesRepository userSpacesRepository;
    private final UserRepository userRepository;
    private final SpaceService spaceService;

    public UserSpacesServiceImpl(UserSpacesRepository userSpacesRepository, UserRepository userRepository, SpaceService spaceService) {
        this.userSpacesRepository = userSpacesRepository;
        this.userRepository = userRepository;
        this.spaceService = spaceService;
    }

    @Override
    public List<Space> listAllSpaces(Long userSpacesId) {
        if(!this.userSpacesRepository.findById(userSpacesId).isPresent())
            throw new UserSpacesNotFound(userSpacesId);
        return this.userSpacesRepository.findById(userSpacesId).get().getSpaceList();
    }

    @Override
    public UserReservedSpaces addSpaceToUserSpaces(Long id, String username) {
        UserReservedSpaces userReservedSpaces = this.getActiveUserSpaces(username);
        Space space = this.spaceService.findById(id)
                .orElseThrow(() -> new SpaceNotFoundException(id));
        if(userReservedSpaces.getSpaceList()
                .stream().filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).size() > 0)
            throw new SpaceExistsException(id);
        userReservedSpaces.getSpaceList().add(space);
        return this.userSpacesRepository.save(userReservedSpaces);
    }

    @Override
    public UserReservedSpaces getActiveUserSpaces(String username) {
        User user = this.userRepository.getUserByUsername(username);

        return this.userSpacesRepository
                .findByUser(user)
                .orElseGet(() -> {
                    UserReservedSpaces userReservedSpaces = new UserReservedSpaces(user);
                    return this.userSpacesRepository.save(userReservedSpaces);
                });
    }
}
