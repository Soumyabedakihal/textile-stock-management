package com.ty.textilestockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.SupplierDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.Supplier;
import com.ty.textilestockmanagement.exception.InvalidEmailException;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class SupplierService {

	@Autowired
	private SupplierDao dao;

	ResponseStructure<Supplier> responseStructure = new ResponseStructure<Supplier>();

	public ResponseStructure<Supplier> saveSupplier(Supplier supplier) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveSupplier(supplier));
		return responseStructure;
	}

	public ResponseStructure<Supplier> getSupplierById(int id) {
		Supplier supplier = dao.getSupplierById(id);
		if (supplier != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplier);
			return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + id + " not found");
	}

	public ResponseStructure<String> deleteSupplier(int id) {
		String supplier = dao.deleteSupplier(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (supplier.equals("user deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplier);
			return responseStructure;
		}
		throw new NoIdFoundException("Shop id " + id + " not found");
	}

	public ResponseStructure<Supplier> updateSupplier(Supplier supplier1) {
		Supplier supplier = dao.updateSupplier(supplier1);
		if (supplier != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(supplier);
			return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + supplier1.getId() + " not found");
	}

	public ResponseStructure<List<Supplier>> getAllSupplier() {
		ResponseStructure<List<Supplier>> responseStructure = new ResponseStructure<List<Supplier>>();
		List<Supplier> list = dao.getAllSupplier();
		if (!list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found Something");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new NoIdFoundException("no data found");
	}

	public ResponseStructure<Supplier> validateSupplier(String email, String password) {
		Supplier supplier = dao.validateSupplier(email, password);
		if (supplier != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Validated Successfully");
			responseStructure.setData(supplier);
			return responseStructure;
		}
		throw new InvalidEmailException("invalid '" + email + "' email or *** password");
	}

}
