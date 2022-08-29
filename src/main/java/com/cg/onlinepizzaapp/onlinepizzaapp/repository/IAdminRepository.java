package com.cg.onlinepizzaapp.onlinepizzaapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Admin;



public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	
	//@Query("select u from Admin u where adminName=?1 and adminPassword=?2")
	// Admin signIn(String adminName ,String adminPassword);
		Optional<Admin> findByAdminNameAndAdminPassword(String adminName,String adminPassword);
}
