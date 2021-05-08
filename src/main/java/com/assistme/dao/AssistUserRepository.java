package com.assistme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistme.models.AssistUser;

@Repository
public interface AssistUserRepository extends JpaRepository<AssistUser, Integer> {
	
    @Query("SELECT a FROM AssistUser a WHERE a.userName = ?1")
	AssistUser findByUsername(String userName);
}
