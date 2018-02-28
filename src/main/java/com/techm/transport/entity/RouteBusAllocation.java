package com.techm.transport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_allocate_to_bus_route")
public class RouteBusAllocation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "tbl_route_route_no")
	private Integer routeNo;
	
	@Column(name="vehicle_registration_number")
	private String vehicleRegId;
	
	@Column(name="driver_name")
	private String driverName;
	
	@Column(name="seat_capacity")
	private Integer seatCapacity;
	
	@Column(name="tbl_journey_type_id")
	private Integer journeyTypeId;
	
	public RouteBusAllocation() {
	}
	public RouteBusAllocation(Integer id, Integer routeNo, String vehicleRegId, String driverName, Integer seatCapacity, Integer journeyTypeId) {
		this.id=id;
		this.routeNo = routeNo;
		this.vehicleRegId = vehicleRegId;
		this.driverName = driverName;
		this.seatCapacity = seatCapacity;
		this.journeyTypeId = journeyTypeId;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(Integer routeNo) {
		this.routeNo = routeNo;
	}
	public String getVehicleRegId() {
		return vehicleRegId;
	}
	public void setVehicleRegId(String vehicleRegId) {
		this.vehicleRegId = vehicleRegId;
	}
	public Integer getJourneyTypeId() {
		return journeyTypeId;
	}
	public void setJourneyTypeId(Integer journeyTypeId) {
		this.journeyTypeId = journeyTypeId;
	}

	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	
}
