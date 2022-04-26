package com.example.reservespace3.repository;

import com.example.reservespace3.model.User;
import com.example.reservespace3.model.UserReservedSpaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSpacesRepository extends JpaRepository<UserReservedSpaces, Long> {
    Optional<UserReservedSpaces> findByUser(User user);
}
