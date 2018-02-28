package com.techm.transport.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.techm.transport.entity.Organization;
import com.techm.transport.exception.TransportException;
import com.techm.transport.service.OrganizationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@RequestMapping("1.0")
@Api(description="Organization operations",tags= {"Organizations"})
public class OrganizationController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrganizationService orgService;
	
	@ApiOperation(value = "${OrganizationController.getOrganization}") 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("orgs/{id}")
	public ResponseEntity<Organization> getOrganization(@ApiParam(name = "id", value = "id of organization", required = true) @PathVariable("id") Integer id){
		LOGGER.info("Getting organization details of id-" + id);
		Organization org = orgService.getOrgbyId(id);
		if (org==null) {
			throw new TransportException("Organization with given id does not exist. Organization Id - "+id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
	
	@ApiOperation(value = "${OrganizationController.getAllOrganizations}") 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
	}
			)
	@GetMapping("orgs")
	public ResponseEntity<List<Organization>> getAllOrganizations(){
		LOGGER.info("Getting all organizations");
		List<Organization> orgs = orgService.getAllOrganizations();
		return new ResponseEntity<List<Organization>>(orgs, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "${OrganizationController.addOrganization}") 
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created resources"),
			@ApiResponse(code = 401, message = "Not authorized to view the resources"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 409, message = "Resource with given name already exists"),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@PostMapping("orgs/{orgname}")
	public ResponseEntity<Organization> addOrganization(@ApiParam(name = "orgname", value = "Name of organization", required = true) @PathVariable("orgname") String name, UriComponentsBuilder builder){
		LOGGER.info("Adding organization. Organization name -"+ name);
		Organization org = orgService.addOrganization(name);
		if (org==null) {
			return new ResponseEntity<Organization>(HttpStatus.CONFLICT);
		}
		Integer orgId = org.getId();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/org/{"+orgId+"}").buildAndExpand(orgId).toUri());
		return new ResponseEntity<Organization>(headers, HttpStatus.CREATED);
	}
	
		
	@ApiOperation(value = "${OrganizationController.getCitiesOfOrg}") 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get all resources"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("orgs/{orgId}/cities")
	public ResponseEntity<Organization> getCitiesOfOrg(@ApiParam(name = "orgId", value = "Id of organization", required = true) @PathVariable("orgId") Integer orgId){
		LOGGER.info("Getting all cities of given organization. Organization Id - "+orgId);
		Organization org = orgService.getCitiesOfOrg(orgId);
		if (org==null) {
			throw new TransportException("Organization with given id does not exist. Organization Id - "+orgId, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
}
