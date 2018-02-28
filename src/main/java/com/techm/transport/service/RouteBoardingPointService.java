package com.techm.transport.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.Organization;
import com.techm.transport.entity.RouteBoardingPoint;
import com.techm.transport.entity.SampleData;
import com.techm.transport.repository.RouteBoardingPointRepository;

@Service
public class RouteBoardingPointService{
	
	@Autowired
	RouteBoardingPointRepository routeBoardingPointRepository;

	public List<RouteBoardingPoint> getAllRouteBoardingPoints(){
		List<RouteBoardingPoint> list = new ArrayList<RouteBoardingPoint>();

		Iterator<RouteBoardingPoint> itr = routeBoardingPointRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public RouteBoardingPoint getRouteBoardingPointById(Integer id) {
		RouteBoardingPoint routeBoardingPoint = routeBoardingPointRepository.findById(id);
		return routeBoardingPoint;
	}
	
	public List<RouteBoardingPoint> getRouteBoardingPointByRouteId(Integer id) {
		List<RouteBoardingPoint> routeBoardingPoints = routeBoardingPointRepository.findByRouteId(id);
		return routeBoardingPoints;
	}
	
	public List<RouteBoardingPoint> getRouteBoardingPointByBoardingPointId(Integer id) {
		List<RouteBoardingPoint> routeBoardingPoints = routeBoardingPointRepository.findByBoardPointId(id);
		return routeBoardingPoints;
	}
	

}
