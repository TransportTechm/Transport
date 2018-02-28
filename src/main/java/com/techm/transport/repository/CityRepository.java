package com.techm.transport.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findByName(String name);
	City findById(Integer id);
	
}
