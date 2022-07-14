package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.ShopOrderProducts;
import com.ty.textilestockmanagement.repository.ShopOrderProductsRepository;

@Repository
public class ShopOrderProductsDao {

	@Autowired
	private ShopOrderProductsRepository orderProductsRepository;
	
	public ShopOrderProducts saveShopOrderProducts(ShopOrderProducts products) {
		return orderProductsRepository.save(products);
	}
	
	public ShopOrderProducts updateShopOrderProducts(ShopOrderProducts products) {
		Optional<ShopOrderProducts> optional = orderProductsRepository.findById(products.getId());
		if(optional.isPresent()) {
			return orderProductsRepository.save(products);
		}
		return null;
	}
	
	public String deleteShopOrderProducts(int id) {
		Optional<ShopOrderProducts> optional = orderProductsRepository.findById(id);
		if(optional.isPresent()) {
			orderProductsRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not Found";
	}
	
	public ShopOrderProducts getByIdShopOrderProducts(int id) {
		Optional<ShopOrderProducts> optional = orderProductsRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<ShopOrderProducts> getAllByShopOrderProducts(){
		return orderProductsRepository.findAll();
	}
}
