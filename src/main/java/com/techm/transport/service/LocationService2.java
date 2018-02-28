package com.techm.transport.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.City;
import com.techm.transport.entity.Location;
import com.techm.transport.entity.SampleData;
import com.techm.transport.repository.LocationRepository;

@Service
public class LocationService2{
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	JourneyTypeService2 journeyTypeService;

	public List<Location> getAllLocations(){
		List<Location> list = new ArrayList<Location>();

		Iterator<Location> itr = locationRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized boolean addLocation(Integer cityId, String locName) {
		Location currentLocation = getLocationbyNameNCityId(cityId, locName); 	
		if (currentLocation!=null) {
			return false;
		} else {
			locationRepository.save(new Location(locName,cityId));
			return true;
		}
	}
	
	public Location getLocationbyNameNCityId(Integer cityId, String locName) {
		Location currentLocation=null;
		List<Location> cities = locationRepository.findByName(locName);
		for (Location city : cities) {
			if (city.getCityId().intValue()==cityId.intValue()) {
				currentLocation=city;
				break;
			}
		}
		return currentLocation;
	}
	
	public Location getLocationById(Integer id) {
		Location city = locationRepository.findById(id);
		return city;
	}
	
	public void updateLocation(Location city) {
		locationRepository.save(city);
	}
	
	public void deleteLocation(Integer id) {
		locationRepository.delete(getLocationById(id));
	}
	
	public Location getJourneyTypesOfLocation(Integer id) {
		Location loc = getLocationById(id);
		loc.setJourneyTypes(journeyTypeService.getJourneyTypesByLocId(id));
		return loc;
	}
	
	public synchronized boolean addLocationToCity(Integer cityId, String locName) {
		Location loc = getLocationbyNameNCityId(cityId, locName);
		if (loc!=null) {
			return false;
		} else {
			locationRepository.save(new Location(locName, cityId));
			return true;
		}
	}
	
	public List<Location> getLocationsByCityId(Integer cityId){
		List<Location> list = locationRepository.findByCityId(cityId);

		/*Iterator<Location> itr = locationRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}*/
		return list;
	}
}
