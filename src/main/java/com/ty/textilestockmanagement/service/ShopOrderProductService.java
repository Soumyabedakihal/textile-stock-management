package com.ty.textilestockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.ShopOrderProductsDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.ShopOrderProducts;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class ShopOrderProductService {

	@Autowired
	private ShopOrderProductsDao dao;
	
	ResponseStructure<ShopOrderProducts> responseStructure = new ResponseStructure<ShopOrderProducts>();

	public ResponseStructure<ShopOrderProducts> saveShopOrderProducts(ShopOrderProducts shopOrderProducts) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveShopOrderProducts(shopOrderProducts));
		return responseStructure;
	}

	public ResponseStructure<ShopOrderProducts> getShopOrderProductsById(int id) {
		ShopOrderProducts shopOrderProducts = dao.getByIdShopOrderProducts(id);
		if (shopOrderProducts != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shopOrderProducts);
			return responseStructure;
		}
		throw new NoIdFoundException("shop Order Product id " + id + " not found");
	}

	public ResponseStructure<String> deleteShopOrderProducts(int id) {
		String shopOrderProducts = dao.deleteShopOrderProducts(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (shopOrderProducts.equals("user deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shopOrderProducts);
			return responseStructure;
		}
		throw new NoIdFoundException("Shop Order Products id " + id + " not found");
	}

	public ResponseStructure<ShopOrderProducts> updateShopOrderProducts(ShopOrderProducts shopOrderProducts1) {
		ShopOrderProducts shopOrderProducts = dao.updateShopOrderProducts(shopOrderProducts1);
		if (shopOrderProducts != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(shopOrderProducts1);
			return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + shopOrderProducts1.getId() + " not found");
	}
}
