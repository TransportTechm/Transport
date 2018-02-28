package com.techm.transport.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SampleData {
	public static final AtomicLong orgCounter = new AtomicLong();
	public static final AtomicLong routeCounter = new AtomicLong(100);
	public static final AtomicLong cityCounter = new AtomicLong(1000);
	public static final AtomicLong locCounter = new AtomicLong(2000);
	public static final AtomicLong bpCounter = new AtomicLong(4000);
	public static final AtomicLong jtCounter = new AtomicLong(600);
	public static final AtomicLong rbpCounter = new AtomicLong(5000);
	public static final AtomicLong rbAllCounter = new AtomicLong(3000);
	
	public static List<Route> populateRoutes(){
		List<Route> routes = new ArrayList<Route>();
		Integer i = (int)routeCounter.incrementAndGet();
		routes.add(new Route(i, "Route-"+i, "JP Nagar", "ELectronic City-II", "7:00" ));
		i = (int)routeCounter.incrementAndGet();
		routes.add(new Route(i, "Route-"+i, "Whitefield", "ELectronic City-II", "7:00" ));
		return routes;	
	}
	
	public static List<Organization> populateOrgs(){
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(new Organization((int)orgCounter.incrementAndGet(), "Tech Mahindra"));
		return orgs;	
	}
	
	public static List<City> populateCities(){
		List<City> cities = new ArrayList<City>();
		cities.add(new City((int)cityCounter.incrementAndGet(), "Bangalore", 1 ));
		cities.add(new City((int)cityCounter.incrementAndGet(), "Hyderbad", 1));
		cities.add(new City((int)cityCounter.incrementAndGet(), "Pune", 1));
		return cities;	
	}

	public static List<Location> populateLocations(){
		List<Location> locs = new ArrayList<Location>();
		locs.add(new Location((int)locCounter.incrementAndGet(), "Electronic city", 1001));
		locs.add(new Location((int)locCounter.incrementAndGet(), "Whitefield", 1001));
		locs.add(new Location((int)locCounter.incrementAndGet(), "hitech city", 1002));
		locs.add(new Location((int)locCounter.incrementAndGet(), "low tech city", 1002));
		locs.add(new Location((int)locCounter.incrementAndGet(), "Hinjewadi", 1003));
		locs.add(new Location((int)locCounter.incrementAndGet(), "Shaniwarwada", 1003));
		return locs;	
	}
	
	public static List<JourneyType> populateJourneyType(){
		List<JourneyType> jTypes = new ArrayList<JourneyType>();
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Yearly Journey Ticket", 2001));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Single Journey Ticket",2001));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Yearly Journey Ticket", 2002));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Single Journey Ticket",2002));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Yearly Journey Ticket", 2003));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Single Journey Ticket",2003));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Yearly Journey Ticket", 2004));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Single Journey Ticket",2004));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Yearly Journey Ticket", 2005));
		jTypes.add(new JourneyType((int)jtCounter.incrementAndGet(), "Single Journey Ticket",2006));
		return jTypes;	
	}
	
	//bpCounter =4000
	public static List<BoardingPoint> populateBoardingPoints(){
		List<BoardingPoint> bPoints = new ArrayList<BoardingPoint>();
		bPoints.add(new BoardingPoint((int)bpCounter.incrementAndGet(), "JP Nagar"));
		bPoints.add(new BoardingPoint((int)bpCounter.incrementAndGet(), "MicoLayout"));
		bPoints.add(new BoardingPoint((int)bpCounter.incrementAndGet(), "Udapi Grden"));
		bPoints.add(new BoardingPoint((int)bpCounter.incrementAndGet(), "Bomanhalli"));
		bPoints.add(new BoardingPoint((int)bpCounter.incrementAndGet(), "Kudlu Gate"));
		bPoints.add(new BoardingPoint((int)bpCounter.incrementAndGet(), "Konappa Agrahara"));
		return bPoints;	
	}
	
	//rbpCounter=5000
	public static List<RouteBoardingPoint> populateRouteBoardingPoints(){
		List<RouteBoardingPoint> rbps = new ArrayList<RouteBoardingPoint>();
		rbps.add(new RouteBoardingPoint((int)rbpCounter.incrementAndGet(), 4001, 101, "7:10"));
		rbps.add(new RouteBoardingPoint((int)rbpCounter.incrementAndGet(), 4002, 101, "7:20"));
		rbps.add(new RouteBoardingPoint((int)rbpCounter.incrementAndGet(), 4003, 101, "7:30"));
		rbps.add(new RouteBoardingPoint((int)rbpCounter.incrementAndGet(), 4004, 102, "7:10"));
		rbps.add(new RouteBoardingPoint((int)rbpCounter.incrementAndGet(), 4005, 102, "7:20"));
		rbps.add(new RouteBoardingPoint((int)rbpCounter.incrementAndGet(), 4006, 102, "7:30"));
		return rbps;	
	}
	
	//rbAllCounter=3000
	public static List<RouteBusAllocation> populateRouteBusAllocation(){
		List<RouteBusAllocation> routeBusAllocs = new ArrayList<RouteBusAllocation>();
		routeBusAllocs.add(new RouteBusAllocation((int)rbAllCounter.incrementAndGet(), 101, "KA-02-JJ-6950", "Anonymous", 45, 601));
		routeBusAllocs.add(new RouteBusAllocation((int)rbAllCounter.incrementAndGet(), 102, "KA-02-JJ-6900", "Anonymous-1", 45, 601));
		return routeBusAllocs;	
	}


}
