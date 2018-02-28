package com.techm.transport.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
	List<Location> findByName(String name);
	List<Location> findByCityId(Integer id);
	Location findById(Integer id);
	
}
