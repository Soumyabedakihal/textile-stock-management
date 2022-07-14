package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.SupplierRequest;
import com.ty.textilestockmanagement.repository.SupplierRequestRepository;

@Repository
public class SupplierRequestDao {

	@Autowired
	SupplierRequestRepository repository;

	public SupplierRequest saveSupplierRequest(SupplierRequest supplierRequest) {
		return repository.save(supplierRequest);
	}

	public SupplierRequest updateSupplierRequest(SupplierRequest supplierRequest) {
		Optional<SupplierRequest> optional = repository.findById(supplierRequest.getId());
		if (optional.isPresent()) {
			return repository.save(supplierRequest);
		}
		return null;
	}

	public SupplierRequest getSupplierRequestById(int id) {
		Optional<SupplierRequest> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteSupplierRequest(int id) {
		Optional<SupplierRequest> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not Found";
	}

	public List<SupplierRequest> getAllSupplierRequest() {
		return repository.findAll();
	}
}