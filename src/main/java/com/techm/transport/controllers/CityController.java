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

import com.techm.transport.entity.City;
import com.techm.transport.service.CityService2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


//@CrossOrigin(origins="/**")
@Controller
@RequestMapping("1.0")
@Api(description="City operations", tags= {"Cities"})
public class CityController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityService2 cityService;

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "${CityController.getCity}", response = City.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("cities")
	public ResponseEntity<List<City>> getAllCities(){
		LOGGER.info("Getting all cities");
		List<City> cities = cityService.getAllCities();
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "${CityController.getCity}", response = City.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
	}
			)
	@GetMapping("cities/{cityId}")
	public ResponseEntity<City> getCity(@ApiParam(name = "cityId", value = "id of city", required = true) @PathVariable("cityId") Integer id){
		LOGGER.info("Getting city details of id-" + id);
		City city = cityService.getCityById(id);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "${CityController.getCityByOrgId}", response = City.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
	}
			)
	@GetMapping("cities/{cityId}/locations")
	public ResponseEntity<City> getLocsOfCity(@ApiParam(name = "cityId", value = "id of city", required = true) @PathVariable("cityId") Integer id){
		LOGGER.info("Getting organization details of id-" + id);
		City city = cityService.getLocsOfcity(id);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param cityName
	 * @param orgId
	 * @param builder
	 * @return
	 */
	@ApiOperation(value = "${CityController.addCity}") 
	@ApiResponses(value= {@ApiResponse(code = 201, message = "${HTTP.201}"), @ApiResponse(code = 401, message = "${HTTP.401}"),
			@ApiResponse(code = 403, message = "${HTTP.403}"), @ApiResponse(code = 404, message = "${HTTP.404}"),
			@ApiResponse(code = 409, message = "${HTTP.409}"), @ApiResponse(code = 500, message = "${HTTP.500}")})

	@PostMapping("cities/{cityName}/org/{orgId}")
	public ResponseEntity<Void> addCity(@ApiParam(name = "cityName", value = "name of city", required = true) @PathVariable("cityName") String cityName,
										@ApiParam(name = "orgId", value = "id of organization", required = true) @PathVariable("orgId") Integer orgId, UriComponentsBuilder builder){
		
		LOGGER.info("Adding city. City name -"+ cityName);
		boolean flag = cityService.addCity(orgId, cityName);
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/org/{id}").buildAndExpand(city.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	

}
