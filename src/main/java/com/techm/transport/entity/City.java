package com.techm.transport.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


//@JsonPropertyOrder({"id", "name"})
@Entity
@Table(name="tbl_journey_city")
//@SequenceGenerator(name="seq", initialValue=1000, allocationSize=100)
public class City {
	
//	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
//	@JsonProperty("name")
	@Column(name="name")
	private String name;
	
//	@JsonIgnore
	@Column(name="tbl_organization_id")
	private Integer orgId;
	
	@Transient
	@JsonInclude(Include.NON_NULL)
	private List<Location> locations;
	
	public City() {
	}
	public City(String name, Integer orgId) {
		this.name = name;
		this.orgId = orgId;
	}
	public City(Integer id, String name, Integer orgId) {
		this.id = id;
		this.name = name;
		this.orgId = orgId;
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

	@JsonIgnore
	public Integer getOrgId() {
		return orgId;
	}
	
	@JsonIgnore
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	@Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (orgId ^ (orgId >>> 32));
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
        City other = (City) obj;
        if (id != other.id && orgId != other.orgId)
            return false;
        return true;
    }
	

}
