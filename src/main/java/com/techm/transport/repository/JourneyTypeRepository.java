package com.techm.transport.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.JourneyType;

@Repository
public interface JourneyTypeRepository extends CrudRepository<JourneyType, Long>{
	List<JourneyType> findByName(String name);
	List<JourneyType> findByLocId(Integer id);
	JourneyType findById(Integer id);
	
}
