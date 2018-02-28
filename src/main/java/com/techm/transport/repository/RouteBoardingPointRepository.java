package com.techm.transport.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.RouteBoardingPoint;

@Repository
public interface RouteBoardingPointRepository extends CrudRepository<RouteBoardingPoint, Long>{
	List<RouteBoardingPoint> findByBoardPointId(Integer id);
	List<RouteBoardingPoint> findByRouteId(Integer id);
	RouteBoardingPoint findById(Integer id);
}
