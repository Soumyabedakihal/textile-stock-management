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
import com.ty.textilestockmanagement.dto.Shop;
import com.ty.textilestockmanagement.dto.ShopOrder;
import com.ty.textilestockmanagement.dto.Supplier;
import com.ty.textilestockmanagement.dto.SupplierRequest;
import com.ty.textilestockmanagement.dto.WareHouse;
import com.ty.textilestockmanagement.service.ShopOrderService;
import com.ty.textilestockmanagement.service.ShopService;
import com.ty.textilestockmanagement.service.SupplierRequestService;
import com.ty.textilestockmanagement.service.SupplierService;
import com.ty.textilestockmanagement.service.WareHouseService;

@RestController
public class AdminController {

	@Autowired
	WareHouseService wareHouseService;
	
	@PostMapping("/admin/warehouse")
	public ResponseStructure<WareHouse> saveWareHouse(@RequestBody WareHouse wareHouse){
		return wareHouseService.saveWareHouse(wareHouse);
	}
	@GetMapping("/admin/warehouse")
	public ResponseStructure<List<WareHouse>> getAllWareHouse(){
		return wareHouseService.getAllWareHouse();
	}
	
	@GetMapping("/admin/warehouse/{id}")
	public ResponseStructure<WareHouse> getWareHouseById(@PathVariable int id){
		return wareHouseService.getWareHouseById(id);
	}
	
	@PutMapping("/admin/warehouse")
	public ResponseStructure<WareHouse> updateWareHouse(@RequestBody WareHouse wareHouse){
		return wareHouseService.updateWareHouse(wareHouse);
	}
	
	@DeleteMapping("/admin/warehouse/{id}")
	public ResponseStructure<String> deleteWareHouse(@PathVariable int id){
		return wareHouseService.deleteWareHouse(id);
	}
	
	@Autowired
	SupplierRequestService supplierRequestService;
	
	@GetMapping("/admin/supplierrequest")
	public ResponseStructure<List<SupplierRequest>> getAllSupplierRequest() {
		return supplierRequestService.getAllSupplierRequest();
	}
	
	@Autowired
	ShopOrderService shopOrderService;
	
	@GetMapping("/admin/shoporder")
	public ResponseStructure<List<ShopOrder>> getAllShopOrder() {
		return shopOrderService.getAllShopOrder();
	}
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("admin/shop/{id}")
	public ResponseStructure<Shop> getShopById(@PathVariable int id){
		return shopService.getShopById(id);
	}
	
	@GetMapping("admin/shop")
	public ResponseStructure<List<Shop>> getAllShops(){
		return shopService.getAllShop();
	}
	
	@DeleteMapping("admin/shop/{id}")
	public ResponseStructure<String> deleteShop(@PathVariable int id){
		return shopService.deleteShop(id); 
	}
	
	@Autowired
	SupplierService supplierService;
	
	@GetMapping("/admin/suppliers")
	public ResponseStructure<List<Supplier>> getAllSupplier(){
		return supplierService.getAllSupplier();
	}
	
	@DeleteMapping("/admin/suppliers/{id}")
	public ResponseStructure<String> deleteSupplierById(@PathVariable int id){
		return supplierService.deleteSupplier(id); 
	}
	
	@GetMapping("/admin/supplier/{id}")
	public ResponseStructure<Supplier> getSupplierById(@PathVariable int id){
		return supplierService.getSupplierById(id);
	}
}