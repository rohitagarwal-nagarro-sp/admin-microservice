package com.nagp.adminmicroservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagp.adminmicroservice.entity.ServiceMaster;

@Repository
public interface AdminRepository extends JpaRepository<ServiceMaster, Integer>
{
	ServiceMaster findByServiceName(String name);
	List<ServiceMaster> findByPrice(String price);
}
