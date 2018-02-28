package com.techm.transport.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.transport.delegate.VendorServiceDelegate;
import com.techm.transport.entity.Route;
import com.techm.transport.service.RouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("1.0")
@Api(description="Route operations",tags= {"Routes"})
public class RouteController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private RouteService routeService;
	
	@ApiOperation(value = "${RouteController.getRouteBoardingPoints}") 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("routes/{routeId}")
	public ResponseEntity<Route> getRouteBoardingPoints(@ApiParam(name = "routeId", value = "Id of route", required = true) @PathVariable("routeId") Integer id){
		LOGGER.info("Getting Route details of id-" + id);
		Route org = routeService.getRoute(id);
		return new ResponseEntity<Route>(org, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "${RouteController.getRouteForLocationAndJourneyType}") 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resources"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("routes/all/{journeytypeId}")
	public ResponseEntity<List<Route>> getRoutesOfLocation(@ApiParam(name = "journeytypeId", value = "Id of journey type", required = true)@PathVariable("journeytypeId") Integer journeyTypeId){
		LOGGER.info("Getting all routes for location based on journey id");
		List<Route> routes = routeService.getRoutesOfLocation(journeyTypeId);
		return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
	}
	
	@ApiOperation(value = "${RouteController.getAllRoutes}") 
	@ApiResponses(value= {@ApiResponse(code = 200, message = "${HTTP.200}"), @ApiResponse(code = 401, message = "${HTTP.401}"),
						@ApiResponse(code = 403, message = "${HTTP.403}"), @ApiResponse(code = 404, message = "${HTTP.404}"),
						@ApiResponse(code = 500, message = "${HTTP.500}")})
	@GetMapping("routes")
	public ResponseEntity<List<Route>> getAllRoutes() throws Exception{
		LOGGER.info("Getting all routes");
		List<Route> routes = routeService.getAllRoutes();
		return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
	}
	
}
