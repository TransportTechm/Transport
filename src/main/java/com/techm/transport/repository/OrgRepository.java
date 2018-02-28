package com.techm.transport.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.entity.Organization;

@Repository
public interface OrgRepository extends CrudRepository<Organization, Long>{
	Organization findByOrgName(String orgName);
	Organization findById(Integer id);
}
