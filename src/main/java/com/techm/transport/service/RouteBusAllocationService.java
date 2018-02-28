package com.techm.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.RouteBusAllocation;
import com.techm.transport.repository.RouteBusAllocationRepository;

@Service
public class RouteBusAllocationService {
	
	@Autowired
	RouteBusAllocationRepository routeBusAllocationRepository;

	public List<RouteBusAllocation> getRoutesOfjourneyTypeId(Integer journeyTypeId) {
		List<RouteBusAllocation> routeBusAllocs = routeBusAllocationRepository.findByJourneyTypeId(journeyTypeId);
		return routeBusAllocs;
	}
	
	/**
	 * Get all routes information from route-bus-allocation
	 * @param routeId
	 * @return
	 */
	/*public List<RouteBusAllocation> getRouteBusAllocationsByRouteId(Integer routeId) {
		List<RouteBusAllocation> routeBusAllocs = new ArrayList<RouteBusAllocation>();
		for (RouteBusAllocation rbusAllo : list) {
			Integer rtId = rbusAllo.getRouteNo();
			if (rtId.intValue()==routeId.intValue()) {
				routeBusAllocs.add(rbusAllo);
			}
		}
		return routeBusAllocs;
	}*/
	
	public List<RouteBusAllocation> getRoutesByRouteId(Integer routeId) {
		List<RouteBusAllocation> rba=routeBusAllocationRepository.findByRouteNo(routeId);
		return rba;
	}

}
