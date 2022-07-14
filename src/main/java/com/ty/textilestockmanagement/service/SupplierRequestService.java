package com.ty.textilestockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.SupplierRequestDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.SupplierRequest;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class SupplierRequestService {

	@Autowired
	private SupplierRequestDao dao;

	ResponseStructure<SupplierRequest> responseStructure = new ResponseStructure<SupplierRequest>();

	public ResponseStructure<SupplierRequest> saveSupplierRequest(SupplierRequest supplierRequest) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveSupplierRequest(supplierRequest));
		return responseStructure;
	}

	public ResponseStructure<SupplierRequest> getSupplierRequestById(int id) {
		SupplierRequest supplierRequest = dao.getSupplierRequestById(id);
		if (supplierRequest != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplierRequest);
			return responseStructure;
		}
		throw new NoIdFoundException("SupplierRequest id " + id + " not found");
	}

	public ResponseStructure<String> deleteSupplierRequest(int id) {
		String supplierRequest = dao.deleteSupplierRequest(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (supplierRequest.equals("user deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplierRequest);
			return responseStructure;
		}
		throw new NoIdFoundException("ShopOrder id " + id + " not found");
	}

	public ResponseStructure<SupplierRequest> updateSupplierRequest(SupplierRequest supplierRequest1) {
		SupplierRequest supplierRequest = dao.updateSupplierRequest(supplierRequest1);
		if (supplierRequest != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(supplierRequest);
			return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + supplierRequest1.getId() + " not found");
	}

	public ResponseStructure<List<SupplierRequest>> getAllSupplierRequest() {
		ResponseStructure<List<SupplierRequest>> responseStructure = new ResponseStructure<List<SupplierRequest>>();
		List<SupplierRequest> list = dao.getAllSupplierRequest();
		if (!list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found Something");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new NoIdFoundException("no data found");
	}
}
