package com.ty.textilestockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.SupplierRequest;
import com.ty.textilestockmanagement.service.SupplierRequestService;

@RestController
public class SupplierRequestController {
	@Autowired
	SupplierRequestService supplierRequestService;
	
	@PostMapping("/supplierrequest")
	public ResponseStructure<SupplierRequest> saveSupplierRequest(@RequestBody SupplierRequest supplierRequest) {
		return supplierRequestService.saveSupplierRequest(supplierRequest);
	}
	
	@GetMapping("/supplierrequest/{id}")
	public ResponseStructure<SupplierRequest> getSupplierRequestById(@PathVariable int id){
		return supplierRequestService.getSupplierRequestById(id);
	}
	
	@PutMapping("/supplierrequest")
	public ResponseStructure<SupplierRequest> updateSupplierRequest(@RequestBody SupplierRequest supplierRequest){
		return supplierRequestService.updateSupplierRequest(supplierRequest);
	}
	
	@DeleteMapping("/supplierrequest")
	public ResponseStructure<String> deleteSupplierRequestById(@PathVariable int id){
		return supplierRequestService.deleteSupplierRequest(id);
	}
}
