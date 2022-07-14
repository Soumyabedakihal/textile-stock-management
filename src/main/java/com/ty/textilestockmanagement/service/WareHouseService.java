package com.ty.textilestockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.textilestockmanagement.dao.WareHouseDao;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.WareHouse;
import com.ty.textilestockmanagement.exception.NoIdFoundException;

@Service
public class WareHouseService {


	@Autowired
	private WareHouseDao dao;

	ResponseStructure<WareHouse> responseStructure = new ResponseStructure<WareHouse>();

	public ResponseStructure<WareHouse> saveWareHouse(WareHouse wareHouse) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveWareHouse(wareHouse));
		return responseStructure;
	}

	public ResponseStructure<WareHouse> getWareHouseById(int id) {
		WareHouse wareHouse = dao.getWareHouseById(id);
		if (wareHouse != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(wareHouse);
			return responseStructure;
		}
		throw new NoIdFoundException("WareHouse id " + id + " not found");
	}

	public ResponseStructure<String> deleteWareHouse(int id) {
		String wareHouse = dao.deleteWareHouse(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (wareHouse.equals("wareHouse deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(wareHouse);
			return responseStructure;
		}
		throw new NoIdFoundException("WareHouse id " + id + " not found");
	}

	public ResponseStructure<WareHouse> updateWareHouse(WareHouse wareHouse1) {
		WareHouse wareHouse = dao.updateWareHouse(wareHouse1);
		if (wareHouse != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found And Updated");
			responseStructure.setData(wareHouse);
			return responseStructure;
		}
		throw new NoIdFoundException("WareHouse id " + wareHouse1.getId() + " not found");
	}

	public ResponseStructure<List<WareHouse>> getAllWareHouse() {
		ResponseStructure<List<WareHouse>> responseStructure = new ResponseStructure<List<WareHouse>>();
		List<WareHouse> list = dao.getAllWareHouse();
		if (!list.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found Something");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new NoIdFoundException("no data found");
	}
	
}
