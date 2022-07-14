package com.ty.textilestockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.ShopOrderDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.ShopOrder;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class ShopOrderService {
	@Autowired
	private ShopOrderDao dao;

	ResponseStructure<ShopOrder> responseStructure = new ResponseStructure<ShopOrder>();

	public ResponseStructure<ShopOrder> saveShopOrder(ShopOrder shopOrder) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveShopOrder(shopOrder));
		return responseStructure;
	}

	public ResponseStructure<ShopOrder> getShopOrderById(int id) {
		ShopOrder shopOrder = dao.getShopOrderById(id);
		if (shopOrder != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shopOrder);
			return responseStructure;
		}
		throw new NoIdFoundException("ShopOrder id " + id + " not found");
	}

	public ResponseStructure<String> deleteShopOrder(int id) {
		String shopOrder = dao.deleteShopOrder(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (shopOrder.equals("user deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shopOrder);
			return responseStructure;
		}
		throw new NoIdFoundException("ShopOrder id " + id + " not found");
	}

	public ResponseStructure<ShopOrder> updateShopOrder(ShopOrder shopOrder1) {
		ShopOrder shopOrder = dao.updateShopOrder(shopOrder1);
		if (shopOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(shopOrder);
			return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + shopOrder1.getId() + " not found");
	}

	public ResponseStructure<List<ShopOrder>> getAllShopOrder() {
		ResponseStructure<List<ShopOrder>> responseStructure = new ResponseStructure<List<ShopOrder>>();
		List<ShopOrder> list = dao.getAllShopOrder();
		if (!list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found Something");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new NoIdFoundException("no data found");
	}
}
