package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.Supplier;
import com.ty.textilestockmanagement.repository.SupplierRepository;

@Repository
public class SupplierDao {

	@Autowired
	private SupplierRepository repository;

	public Supplier getSupplierById(int id) {
		Optional<Supplier> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Supplier saveSupplier(Supplier supplier) {
		return repository.save(supplier);
	}

	public Supplier updateSupplier(Supplier supplier) {
		Optional<Supplier> optional = repository.findById(supplier.getId());
		if (optional.isPresent()) {
			return repository.save(supplier);
		}
		return null;
	}

	public String deleteSupplier(int id) {
		Optional<Supplier> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return "Deleted Successfully";
		}
		return null;
	}

	public List<Supplier> getAllSupplier() {
		return repository.findAll();
	}

	public Supplier validateSupplier(String email, String password) {
		return repository.validateSupplier(email, password);
	}
}
