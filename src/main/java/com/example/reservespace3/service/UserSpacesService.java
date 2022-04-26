package com.example.reservespace3.service;

import com.example.reservespace3.model.Space;
import com.example.reservespace3.model.UserReservedSpaces;

import java.util.List;

public interface UserSpacesService {
    List<Space> listAllSpaces(Long userSpacesId);
    UserReservedSpaces addSpaceToUserSpaces(Long id, String username);
    UserReservedSpaces getActiveUserSpaces(String username);
}
