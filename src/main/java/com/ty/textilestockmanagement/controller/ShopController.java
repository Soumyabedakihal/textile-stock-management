package com.ty.textilestockmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilestockmanagement.dto.Login;
import com.ty.textilestockmanagement.dto.ResponseStructure;
import com.ty.textilestockmanagement.dto.Shop;
import com.ty.textilestockmanagement.service.ShopService;


@RestController
public class ShopController {
	@Autowired
	ShopService shopService;
	
	@PostMapping("/shop")
	public ResponseStructure<Shop> saveShop(@RequestBody @Valid Shop shop){
		return shopService.saveShop(shop);
	}
	
	@PutMapping("/shop")
	public ResponseStructure<Shop> updateShop(@RequestBody @Valid Shop shop){
		return shopService.updateShop(shop);
	}
	
	@DeleteMapping("/shop/{id}")
	public ResponseStructure<String> deleteShop(@PathVariable int id){
		return shopService.deleteShop(id); 
	}
	
	@PostMapping("/shop/login")
	public ResponseStructure<Shop> validateShop(@RequestBody Login login){
		return shopService.validateShop(login.getEmail(),login.getPassword());
	}
}
