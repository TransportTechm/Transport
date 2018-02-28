package com.techm.transport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_journey_type")
public class JourneyType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
//	@JsonProperty("name")
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@Column(name="tbl_journey_location_id")
	private Integer locId;
	
	public JourneyType() {
	}
	public JourneyType(String name, Integer locId) {
		this.name = name;
		this.locId = locId;
	}
	public JourneyType(Integer id, String name, Integer locId) {
		this.id = id;
		this.name = name;
		this.locId = locId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getLocId() {
		return locId;
	}
	public void setLocId(Integer locId) {
		this.locId = locId;
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
		JourneyType other = (JourneyType) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
