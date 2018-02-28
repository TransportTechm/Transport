package com.techm.transport.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.City;
import com.techm.transport.entity.Location;
import com.techm.transport.entity.SampleData;
import com.techm.transport.repository.CityRepository;

@Service
public class CityService2{
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	LocationService2 locationService;

	public List<City> getAllCities(){
		List<City> list = new ArrayList<City>();

		Iterator<City> itr = cityRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized boolean addCity(Integer orgId, String cityName) {
		City currentCity = getCitybyNameNOrgId(orgId, cityName); 	
		if (currentCity!=null) {
			return false;
		} else {
			cityRepository.save(new City(cityName,orgId));
			return true;
		}
	}
	
	public City getCitybyNameNOrgId(Integer orgId, String cityName) {
		City currentCity=null;
		List<City> cities = cityRepository.findByName(cityName);
		for (City city : cities) {
			if (city.getOrgId().intValue()==orgId.intValue()) {
				currentCity=city;
				break;
			}
		}
		return currentCity;
	}
	
	public City getCityById(Integer id) {
		City city = cityRepository.findById(id);
		return city;
	}
	
	public void updateCity(City city) {
		cityRepository.save(city);
	}
	
	public void deleteCity(Integer id) {
		cityRepository.delete(getCityById(id));
	}
	
	public City getLocsOfcity(Integer cityId) {
		City city = getCityById(cityId);
		List<Location> locs = new ArrayList<Location>();
		for (Location l : locationService.getLocationsByCityId(cityId)) {
			if (l.getCityId().intValue()==cityId.intValue()) {
				locs.add(l);
			}
		}
		city.setLocations(locs);
		return city;
	}
	
}
