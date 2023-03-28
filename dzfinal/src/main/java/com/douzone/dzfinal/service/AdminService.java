package com.douzone.dzfinal.service;

import org.springframework.stereotype.Service;

import com.douzone.dzfinal.repository.AdminRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public void register() {
		adminRepository.register();
	}
}
