package com.ty.textilestockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilestockmanagement.dto.AdminRequest;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.service.AdminRequestService;

@RestController
public class AdminRequestController {

	@Autowired
	private AdminRequestService requestService;
	
	@PostMapping("/adminrequest")
	public ResponseStructure<AdminRequest> saveAdminRequest(@RequestBody AdminRequest adminRequest) {
		return requestService.saveAdminRequest(adminRequest);
	}
	
	@GetMapping("/adminrequest/{id}")
	public ResponseStructure<AdminRequest> getAdminRequestById(@PathVariable int id){
		return requestService.getAdminRequestById(id);
	}
	
	@PutMapping("/adminrequest")
	public ResponseStructure<AdminRequest> updateAdminRequest(@RequestBody AdminRequest adminRequest){
		return requestService.updateAdminRequest(adminRequest);
	}
	
	@DeleteMapping("/adminrequest")
	public ResponseStructure<String> deleteAdminRequest(@PathVariable int id){
		return requestService.deleteAdminRequest(id);
	}
}
