package com.ty.textilestockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.WareHouse;
import com.ty.textilestockmanagement.service.WareHouseService;

@RestController
public class WareHouseController {
	@Autowired
	WareHouseService wareHouseService;
	
	@PostMapping("/warehouse")
	public ResponseStructure<WareHouse> saveWareHouse(@RequestBody WareHouse wareHouse){
		return wareHouseService.saveWareHouse(wareHouse);
	}
	@GetMapping("/warehouse")
	public ResponseStructure<List<WareHouse>> getAllWareHouse(){
		return wareHouseService.getAllWareHouse();
	}
	
	@GetMapping("/warehouse/{id}")
	public ResponseStructure<WareHouse> getWareHouseById(@PathVariable int id){
		return wareHouseService.getWareHouseById(id);
	}
	
	@PutMapping("/warehouse")
	public ResponseStructure<WareHouse> updateWareHouse(@RequestBody WareHouse wareHouse){
		return wareHouseService.updateWareHouse(wareHouse);
	}
	
	@DeleteMapping("/warehouse/{id}")
	public ResponseStructure<String> deleteWareHouse(@PathVariable int id){
		return wareHouseService.deleteWareHouse(id);
	}
}