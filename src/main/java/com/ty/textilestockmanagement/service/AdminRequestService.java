package com.ty.textilestockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.AdminRequestDao;
import com.ty.textilestockmanagement.dto.AdminRequest;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class AdminRequestService {

	@Autowired
	private AdminRequestDao dao;
	
	ResponseStructure<AdminRequest> responseStructure = new ResponseStructure<AdminRequest>();

	public ResponseStructure<AdminRequest> saveAdminRequest(AdminRequest adminRequest) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveSupplierRequest(adminRequest));
		return responseStructure;
	}

	public ResponseStructure<AdminRequest> getAdminRequestById(int id) {
		AdminRequest adminRequest = dao.getAdminRequestById(id);
		if (adminRequest != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(adminRequest);
			return responseStructure;
		}
		throw new NoIdFoundException("AdminRequest id " + id + " not found");
	}

	public ResponseStructure<String> deleteAdminRequest(int id) {
		String adminRequest = dao.deleteAdminRequest(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (adminRequest.equals("Admin request deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(adminRequest);
			return responseStructure;
		}
		throw new NoIdFoundException("AdminRequest id " + id + " not found");
	}

	public ResponseStructure<AdminRequest> updateAdminRequest(AdminRequest adminRequest1) {
		AdminRequest adminRequest = dao.updateAdminRequest(adminRequest1);
		if (adminRequest != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(adminRequest);
			return responseStructure;
		}
		throw new NoIdFoundException("Admin Request id " + adminRequest1.getId() + " not found");
	}

	public ResponseStructure<List<AdminRequest>> getAllAdminRequest() {
		ResponseStructure<List<AdminRequest>> responseStructure = new ResponseStructure<List<AdminRequest>>();
		List<AdminRequest> list = dao.getAllAdminRequest();
		if (!list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found Something");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new NoIdFoundException("no data found");
	}
}
