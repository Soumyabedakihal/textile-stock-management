package com.ty.textilestockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.ShopDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.Shop;
import com.ty.textilestockmanagement.exception.InvalidEmailException;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class ShopService {

	@Autowired
	private ShopDao dao;

	ResponseStructure<Shop> responseStructure = new ResponseStructure<Shop>();

	public ResponseStructure<Shop> saveShop(Shop shop) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveShop(shop));
		return responseStructure;
	}

	public ResponseStructure<Shop> getShopById(int id) {
		Shop shop = dao.getShopById(id);
		if (shop != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shop);
			return responseStructure;
		}
		throw new NoIdFoundException("Shop id " + id + " not found");
	}

	public ResponseStructure<String> deleteShop(int id) {
		String shop = dao.deleteShop(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (shop.equals("user deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shop);
			return responseStructure;
		}
		throw new NoIdFoundException("Shop id " + id + " not found");
	}

	public ResponseStructure<Shop> updateShop(Shop shop1) {
		Shop shop = dao.updateShop(shop1);
		if (shop != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(shop);
			return responseStructure;
		}
		throw new NoIdFoundException("Shop id " + shop1.getId() + " not found");
	}

	public ResponseStructure<List<Shop>> getAllShop() {
		ResponseStructure<List<Shop>> responseStructure = new ResponseStructure<List<Shop>>();
		List<Shop> list = dao.getAllShop();
		if (!list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found Something");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new NoIdFoundException("no data found");
	}

	public ResponseStructure<Shop> validateShop(String email, String password) {
		Shop shop = dao.validateShop(email, password);
		if (shop != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Validated Successfully");
			responseStructure.setData(shop);
			return responseStructure;
		}
		throw new InvalidEmailException("invalid '" + email + "' email or *** password");
	}
}
