package com.techm.transport.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.City;
import com.techm.transport.entity.JourneyType;
import com.techm.transport.entity.Location;
import com.techm.transport.entity.SampleData;
import com.techm.transport.repository.JourneyTypeRepository;
import com.techm.transport.repository.LocationRepository;

@Service
public class JourneyTypeService2{
	@Autowired
	JourneyTypeRepository journeyTypeRepository;
	
	public List<JourneyType> getAllJourneyTypes(){
		List<JourneyType> list = new ArrayList<JourneyType>();
		Iterator<JourneyType> itr = journeyTypeRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}
	
	public List<JourneyType> getJourneyTypesByLocId(Integer locId){
		List<JourneyType> list = journeyTypeRepository.findByLocId(locId);
		return list;
	}
	
	
}
