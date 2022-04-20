package com.nagp.adminmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.adminmicroservice.entity.ServiceMaster;
import com.nagp.adminmicroservice.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/getAllServices")
	public ResponseEntity<List<ServiceMaster>> getAllServices() 
	{
		List<ServiceMaster> list=adminService.getAllServices();
		return new ResponseEntity<List<ServiceMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceByName")
	public ResponseEntity<ServiceMaster> getServiceByName(@RequestParam("name") String name)
	{
		return new ResponseEntity<ServiceMaster>(adminService.getServiceByName(name), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceByPrice")
	public ResponseEntity<List<ServiceMaster>> getServiceByPrice(@RequestParam("price") String price)
	{
		return new ResponseEntity<List<ServiceMaster>>(adminService.findByPrice(price), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/addService")
	public ResponseEntity<ServiceMaster> addService(@RequestBody ServiceMaster eservice)
	{
		ServiceMaster service=adminService.save(eservice);
		if(service == null) {
			return new ResponseEntity<ServiceMaster>(service,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ServiceMaster>(service,new HttpHeaders(), HttpStatus.OK);
	}
}