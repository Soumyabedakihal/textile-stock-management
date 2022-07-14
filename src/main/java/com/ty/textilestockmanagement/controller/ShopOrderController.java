package com.ty.textilestockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.ShopOrder;
import com.ty.textilestockmanagement.service.ShopOrderService;

@RestController
public class ShopOrderController {
	@Autowired
	ShopOrderService shopOrderService;
	
	@PostMapping("/shoporder")
	public ResponseStructure<ShopOrder> saveShopOrder(@RequestBody ShopOrder shopOrder) {
		return shopOrderService.saveShopOrder(shopOrder);
	}
	
	@GetMapping("/shoporder/{id}")
	public ResponseStructure<ShopOrder> getShopOrderById(@PathVariable int id){
		return shopOrderService.getShopOrderById(id);
	}
	
	@PutMapping("/shoporder")
	public ResponseStructure<ShopOrder> updateShopOrder(@RequestBody ShopOrder shopOrder){
		return shopOrderService.updateShopOrder(shopOrder);
	}
	
	@DeleteMapping("/shoporder/{id}")
	public ResponseStructure<String> deleteShopOrderById(@PathVariable int id){
		return shopOrderService.deleteShopOrder(id);
	}
}
