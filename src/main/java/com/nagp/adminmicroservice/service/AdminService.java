package com.nagp.adminmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.adminmicroservice.entity.ServiceMaster;
import com.nagp.adminmicroservice.repo.AdminRepository;

@Service
public class AdminService {
 
	@Autowired
	AdminRepository adminRepository;

	public List<ServiceMaster> getAllServices() {
		return adminRepository.findAll();
	}
	
	public ServiceMaster getServiceByName(String name) {
		return adminRepository.findByServiceName(name);
	}
	
	public List<ServiceMaster> findByPrice(String price) {
		return adminRepository.findByPrice(price);
	}

	public ServiceMaster save(ServiceMaster service) {
		return adminRepository.save(service);
	}
}
