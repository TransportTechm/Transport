package com.techm.transport.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.Location;
import com.techm.transport.entity.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long>{
	List<Route> findByName(String name);
	Route findByRouteNo(Integer id);
//	List<Route> findByCityId(Integer id);
	
}
