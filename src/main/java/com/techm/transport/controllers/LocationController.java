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

import com.techm.transport.entity.Location;
import com.techm.transport.service.LocationService2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@RequestMapping("1.0")
@Api(description="Location operations", tags= {"Locations"})
public class LocationController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LocationService2 locationService;

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "${LocationController.getLocation}", response = Location.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("locs")
	public ResponseEntity<List<Location>> getAllLocations(){
		LOGGER.info("Getting all locations");
		List<Location> locations = locationService.getAllLocations();
		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "${LocationController.getLocation}", response = Location.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
	}
			)
	@GetMapping("locs/{locId}")
	public ResponseEntity<Location> getLocation(@ApiParam(name = "locId", value = "Id of location", required = true) @PathVariable("locId") Integer id){
		LOGGER.info("Getting location details for given id-" + id);
		Location Location = locationService.getLocationById(id);
		return new ResponseEntity<Location>(Location, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "${LocationController.getJourneyTypesOfLocation}", response = Location.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
	}
			)
	@GetMapping("locs/{locId}/journeyTypes")
	public ResponseEntity<Location> getJourneyTypesOfLocation(@ApiParam(name = "locId", value = "Id of location", required = true) @PathVariable("locId") Integer id){
		LOGGER.info("Getting journey types of given location id -" + id);
		Location Location = locationService.getJourneyTypesOfLocation(id);
		return new ResponseEntity<Location>(Location, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param locName
	 * @param cityId
	 * @param builder
	 * @return
	 */
	@ApiOperation(value = "${OrganizationController.addLocation}") 
	@ApiResponses(value= {@ApiResponse(code = 201, message = "${HTTP.201}"), @ApiResponse(code = 401, message = "${HTTP.401}"),
			@ApiResponse(code = 403, message = "${HTTP.403}"), @ApiResponse(code = 404, message = "${HTTP.404}"),
			@ApiResponse(code = 409, message = "${HTTP.409}"), @ApiResponse(code = 500, message = "${HTTP.500}")})

	@PostMapping("locs/{locName}/city/{cityId}")
	public ResponseEntity<Void> addLocation(@ApiParam(name = "locName", value = "Name of location", required = true) @PathVariable("locName") String locName,
											@ApiParam(name = "cityId", value = "Id of City", required = true) @PathVariable("cityId") Integer cityId, UriComponentsBuilder builder){
		LOGGER.info("Adding location to given city.");
		boolean flag = locationService.addLocationToCity(cityId, locName);
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/org/{id}").buildAndExpand(Location.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	

}
