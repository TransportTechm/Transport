package com.techm.transport.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonPropertyOrder({"id", "name"})
@Entity
@Table(name="tbl_journey_location")
public class Location {
	
//	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
//	@JsonProperty("name")
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@Column(name="tbl_journey_city_id")
	private Integer cityId;
	
	@Transient
	@JsonInclude(Include.NON_NULL)
	private List<JourneyType> journeyTypes;
	
	public Location() {
	}
	public Location(String name, Integer cityId) {
		this.name = name;
		this.cityId = cityId;
	}
	public Location(Integer id, String name, Integer cityId) {
		this.id = id;
		this.name = name;
		this.cityId = cityId;
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
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public List<JourneyType> getJourneyTypes() {
		return journeyTypes;
	}

	public void setJourneyTypes(List<JourneyType> journeyTypes) {
		this.journeyTypes = journeyTypes;
	}

	@Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (cityId ^ (cityId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (id != other.id && cityId != other.cityId)
            return false;
        return true;
    }

}
