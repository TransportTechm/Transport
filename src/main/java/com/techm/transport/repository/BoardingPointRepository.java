package com.techm.transport.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.BoardingPoint;

@Repository
public interface BoardingPointRepository extends CrudRepository<BoardingPoint, Long>{
	BoardingPoint findByName(String name);
	BoardingPoint findById(Integer id);
	
}
