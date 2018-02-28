package com.techm.transport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_route_to_bording")
public class RouteBoardingPoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "tbl_boarding_point_id")
	private Integer boardPointId;
	
	@Column(name = "tbl_route_route_no")
	private Integer routeId;
	
	@Column(name = "departure_time")
	private String departureTime;
	
	public RouteBoardingPoint() {
	}
	
	public RouteBoardingPoint(Integer id, Integer boardPointId, Integer routeId, String departureTime) {
		this.id = id;
		this.boardPointId = boardPointId;
		this.routeId = routeId;
		this.departureTime = departureTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBoardPointId() {
		return boardPointId;
	}
	public void setBoardPointId(Integer boardPointId) {
		this.boardPointId = boardPointId;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		RouteBoardingPoint other = (RouteBoardingPoint) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
