package com.example.reservespace3.repository;
import com.example.reservespace3.bootstrap.DataHolder;
import com.example.reservespace3.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    City findByName(String name);
    City deleteByName(String name);
}
