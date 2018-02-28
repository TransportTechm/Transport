package com.techm.transport.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="tbl_route")
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "route_no", updatable = false, nullable = false)
	private Integer routeNo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="departure_time")
	private String departureTime;
	
	@Transient
	private Integer seatCapacity;
	@Transient
	private String vehicleRegNO;
	@Transient
	private String driverName;
	
	@Transient
	@JsonInclude(Include.NON_NULL)
	private List<BoardingPoint> boarding_points;
	
	public Route() {
		
	}
	public Route(Integer routeNo, String name, String origin, String destination, String departureTime) {
		this.routeNo=routeNo;
		this.name=name;
		this.origin=origin;
		this.destination=destination;
		this.departureTime=departureTime;
	}
	
	public Integer getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(Integer routeNo) {
		this.routeNo = routeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public List<BoardingPoint> getBpoints() {
		return boarding_points;
	}
	
	public void setBpoints(List<BoardingPoint> bpoints) {
		this.boarding_points = bpoints;
	}
	
	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getVehicleRegNO() {
		return vehicleRegNO;
	}

	public void setVehicleRegNO(String vehicleRegNO) {
		this.vehicleRegNO = vehicleRegNO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (routeNo ^ (routeNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (routeNo != other.routeNo)
			return false;
		return true;
	}
	
}
