package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.Shop;
import com.ty.textilestockmanagement.repository.ShopRepository;

@Repository
public class ShopDao {

	@Autowired
	private ShopRepository shopRepository;

	public Shop saveShop(Shop shop) {
		return shopRepository.save(shop);
	}

	public Shop updateShop(Shop shop) {
		Optional<Shop> optional = shopRepository.findById(shop.getId());
		if (optional.isPresent()) {
			return shopRepository.save(shop);
		}
		return null;
	}

	public String deleteShop(int id) {
		Optional<Shop> optional = shopRepository.findById(id);
		if (optional.isPresent()) {
			shopRepository.deleteById(id);
			return "Successfully Deleted";
		}
		return "Not Found";
	}

	public Shop getShopById(int id) {
		Optional<Shop> optional = shopRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Shop> getAllShop() {
		return shopRepository.findAll();
	}

	public Shop validateShop(String email, String password) {
		return shopRepository.validateShop(email, password);
	}
}
