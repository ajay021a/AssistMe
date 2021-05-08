package com.assistme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assistme.models.UserRoles;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Integer> {
	
}
