package com.techm.transport.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.City;
import com.techm.transport.entity.Organization;
import com.techm.transport.entity.SampleData;
import com.techm.transport.repository.OrgRepository;

@Service
public class OrganizationService{

	@Autowired
	private OrgRepository orgRepository;
	
	@Autowired
	CityService2 cityService;

	public List<Organization> getAllOrganizations(){
		List<Organization> list = new ArrayList<Organization>();

		Iterator<Organization> itr = orgRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	/*public synchronized boolean addOrganization(String orgName) {
		Organization currentOrg = getOrgbyName(orgName); 	
		if (currentOrg!=null) {
			return false;
		} else {
			Organization org = new Organization(orgName);
			orgRepository.save(org);
			return true;
		}
	}*/
	
	public synchronized Organization addOrganization(String orgName) {
		Organization org = null;
		Organization currentOrg = getOrgbyName(orgName);
		if (currentOrg==null) {
			org = orgRepository.save(new Organization(orgName));
		}
		return org;
	}

	public Organization getOrgbyName(String orgName) {
		Organization org = orgRepository.findByOrgName(orgName);
		return org;
	}
	public Organization getOrgbyId(Integer id) {
		Organization org = orgRepository.findById(id);
		return org;
	}

	public void updateOrganization(Organization org) {
		orgRepository.save(org);
	}

	public void deleteOrganization(Integer id) {
		orgRepository.delete(getOrgbyId(id));
	}
	
	public Organization getCitiesOfOrg(Integer orgId) {
		Organization org = getOrgbyId(orgId);
		List<City> cities = new ArrayList<City>();
		for (City c : cityService.getAllCities()) {
			if (c.getOrgId().intValue()==orgId.intValue()) {
				c.setLocations(null);
				cities.add(c);
			}
		}
		org.setCities(cities);
		return org;
	}
	
}
