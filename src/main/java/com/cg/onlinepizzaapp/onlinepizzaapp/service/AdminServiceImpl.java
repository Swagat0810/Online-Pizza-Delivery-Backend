package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Admin;

import com.cg.onlinepizzaapp.onlinepizzaapp.exception.UserNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IAdminRepository;


@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private IAdminRepository adminRepository;
	/*
	 * login
	 */
	public Admin signIn(String adminName, String adminPassword) {
		Optional<Admin> signedUser=adminRepository.findByAdminNameAndAdminPassword(adminName, adminPassword);
		if(signedUser.isPresent()) {
			return signedUser.get();
		}
		else {
			throw new UserNotFoundException("Not found");
		}
	}
	/*
	 * adding user
	 */
	public Admin addNewAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}
	
			/*
	 * logout
	 */
	public String signOut(Admin admin) {

		return "SignedOut Successfully";

	}
		
	}
			

