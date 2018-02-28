package com.techm.transport.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.TransactionalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.delegate.VendorServiceDelegate;
import com.techm.transport.entity.BoardingPoint;
import com.techm.transport.entity.Route;
import com.techm.transport.entity.RouteBoardingPoint;
import com.techm.transport.entity.RouteBusAllocation;
import com.techm.transport.entity.SampleData;
import com.techm.transport.exception.TransportException;
import com.techm.transport.repository.RouteRepository;

@Service
public class RouteService{
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	RouteBoardingPointService routeBoardingPointService;
	
	@Autowired
	BoardingPointService boardingPointService;

	@Autowired
	RouteBusAllocationService routeBusAllocationService;
	
	@Autowired
	private VendorServiceDelegate vendorServiceDelegate;

	public List<Route> getAllRoutes() throws Exception{
		List<Route> list = new ArrayList<Route>();

		Iterator<Route> itr = routeRepository.findAll().iterator();
		while(itr.hasNext()) {
			Route route1 = itr.next();
			List<RouteBusAllocation> routesBusAllocs = routeBusAllocationService.getRoutesByRouteId(route1.getRouteNo());
			RouteBusAllocation rba = routesBusAllocs.get(0);
			String response = vendorServiceDelegate.callVendorServiceAndGetAllDrivers();
			if (response.equals("CIRCUIT_BREAKER_ENABLED")) {
				throw new Exception("Vendor Service is not avilable. Please try after some time");
			}
			Route route = getRouteBoardingPoints(route1.getRouteNo());
			route.setVehicleRegNO(rba.getVehicleRegId());
			route.setDriverName(rba.getDriverName());
			route.setSeatCapacity(rba.getSeatCapacity());
			list.add(route); 
		}
		return list;
	}

	public Route getRouteById(Integer id) {
		Route route = routeRepository.findByRouteNo(id);
		return route;
	}
	
	public Route getRouteBoardingPoints(Integer id) {
		Route route = getRouteById(id);
		List<BoardingPoint> bpoints = new ArrayList<BoardingPoint>();
		for (RouteBoardingPoint rbp : routeBoardingPointService.getRouteBoardingPointByRouteId(id)) {
			BoardingPoint bp = boardingPointService.getBoardingPointById(rbp.getBoardPointId());
			bp.setDepartureTime(rbp.getDepartureTime());
			bpoints.add(bp);
		}
		route.setBpoints(bpoints);
		return route;
	}
	
	public List<Route> getRoutesOfLocation(Integer journeyTypeId){
		List<Route> routes = new ArrayList<Route>();
		List<RouteBusAllocation> routeIds = routeBusAllocationService.getRoutesOfjourneyTypeId(journeyTypeId);
		for (RouteBusAllocation routeBusAlloc : routeIds) {
			Route route = getRouteBoardingPoints(routeBusAlloc.getRouteNo());
			route.setVehicleRegNO(routeBusAlloc.getVehicleRegId());
			route.setDriverName(routeBusAlloc.getDriverName());
			route.setSeatCapacity(routeBusAlloc.getSeatCapacity());
			routes.add(route);
		}
		return routes;
	}
	public Route getRoute(Integer routId){
		List<RouteBusAllocation> rbas = routeBusAllocationService.getRoutesByRouteId(routId);
		RouteBusAllocation rba = rbas.get(0);
//		Route route = getRouteById(routId);
		Route route = getRouteBoardingPoints(routId);
		route.setVehicleRegNO(rba.getVehicleRegId());
		route.setDriverName(rba.getDriverName());
		route.setSeatCapacity(rba.getSeatCapacity());
		
		return route;
	}

	/*public Route getRouteByName(String orgName) {
		Route org = orgRepository.findByOrgName(orgName);
		return org;
	}*/
	
}
