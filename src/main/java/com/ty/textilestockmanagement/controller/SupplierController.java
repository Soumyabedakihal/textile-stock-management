package com.ty.textilestockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilestockmanagement.dto.AdminRequest;
import com.ty.textilestockmanagement.dto.Login;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.Supplier;
import com.ty.textilestockmanagement.service.AdminRequestService;
import com.ty.textilestockmanagement.service.SupplierService;

@RestController
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@PostMapping("/supplier")
	public ResponseStructure<Supplier> saveSupplier(@RequestBody Supplier supplier) {
		return supplierService.saveSupplier(supplier);
	}

	@PutMapping("/supplier")
	public ResponseStructure<Supplier> updateSupplier(@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(supplier);
	}

	@DeleteMapping("/supplier/{id}")
	public ResponseStructure<String> deleteSupplierById(@PathVariable int id) {
		return supplierService.deleteSupplier(id);
	}

	@Autowired
	private AdminRequestService requestService;

	@GetMapping("/supplier/adminrequest")
	public ResponseStructure<List<AdminRequest>> getAllAdminRequest() {
		return requestService.getAllAdminRequest();
	}

	@PostMapping("/supplier/login")
	public ResponseStructure<Supplier> validateSupplier(@RequestBody Login login) {
		return supplierService.validateSupplier(login.getEmail(), login.getPassword());
	}
}
