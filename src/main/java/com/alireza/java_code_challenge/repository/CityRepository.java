package com.alireza.java_code_challenge.repository;


import com.alireza.java_code_challenge.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByCountyId(Long countyId);
}
