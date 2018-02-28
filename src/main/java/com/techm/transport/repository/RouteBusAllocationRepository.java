package com.techm.transport.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.Location;
import com.techm.transport.entity.Route;
import com.techm.transport.entity.RouteBusAllocation;

@Repository
public interface RouteBusAllocationRepository extends CrudRepository<RouteBusAllocation, Long>{
	List<RouteBusAllocation> findByJourneyTypeId(Integer id);
	List<RouteBusAllocation> findByRouteNo(Integer id);
//	List<Route> findByCityId(Integer id);
//	Route findById(Integer id);
	
}
