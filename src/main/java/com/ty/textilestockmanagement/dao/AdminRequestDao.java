package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.AdminRequest;
import com.ty.textilestockmanagement.repository.AdminRequestRepository;

@Repository
public class AdminRequestDao {

	@Autowired
	private AdminRequestRepository repository;
	
	public AdminRequest saveSupplierRequest(AdminRequest adminRequest) {
		return repository.save(adminRequest);
	}

	public AdminRequest updateAdminRequest(AdminRequest adminRequest) {
		Optional<AdminRequest> optional = repository.findById(adminRequest.getId());
		if (optional.isPresent()) {
			return repository.save(adminRequest);
		}
		return null;
	}

	public AdminRequest getAdminRequestById(int id) {
		Optional<AdminRequest> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteAdminRequest(int id) {
		Optional<AdminRequest> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not Found";
	}

	public List<AdminRequest> getAllAdminRequest() {
		return repository.findAll();
	}
}
