package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.ShopOrder;
import com.ty.textilestockmanagement.repository.ShopOrderRepository;

@Repository
public class ShopOrderDao {

	@Autowired
	private ShopOrderRepository orderRepository;
	
	public ShopOrder saveShopOrder(ShopOrder order) {
		return orderRepository.save(order);
	}
	
	public ShopOrder getShopOrderById(int id) {
		Optional<ShopOrder> optional = orderRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteShopOrder(int id) {
		Optional<ShopOrder> optional = orderRepository.findById(id);
		if(optional.isPresent()) {
			orderRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return null;
	}
	
	public ShopOrder updateShopOrder(ShopOrder order) {
		Optional<ShopOrder> optional = orderRepository.findById(order.getId());
		if(optional.isPresent()) {
			return orderRepository.save(order);
		}
		return null;
	}
	
	public List<ShopOrder> getAllShopOrder(){
		return orderRepository.findAll();
	}
}
