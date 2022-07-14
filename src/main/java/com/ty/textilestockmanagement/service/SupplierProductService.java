package com.ty.textilestockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.SupplierProductsDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.SupplierProducts;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class SupplierProductService {

	@Autowired
	private SupplierProductsDao dao;
	
	ResponseStructure<SupplierProducts> responseStructure = new ResponseStructure<SupplierProducts>();

	public ResponseStructure<SupplierProducts> saveSupplierRequest(SupplierProducts supplierProducts) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveSupplierProducts(supplierProducts));
		return responseStructure;
	}

	public ResponseStructure<SupplierProducts> getSupplierProductsById(int id) {
		SupplierProducts supplierProducts = dao.getSupplierProductsById(id);
		if (supplierProducts != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplierProducts);
			return responseStructure;
		}
		throw new NoIdFoundException("SupplierProducts id " + id + " not found");
	}

	public ResponseStructure<String> deleteSupplierProducts(int id) {
		String supplierProducts = dao.deleteSupplierProducts(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (supplierProducts.equals("supplier Product deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplierProducts);
			return responseStructure;
		}
		throw new NoIdFoundException("supplier Product id " + id + " not found");
	}

	public ResponseStructure<SupplierProducts> updateSupplierProducts(SupplierProducts supplierProducts1) {
		SupplierProducts supplierProducts = dao.updateSupplierProducts(supplierProducts1);
		if (supplierProducts != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(supplierProducts);
			return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + supplierProducts1.getId() + " not found");
	}
}
