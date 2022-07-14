package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.SupplierProducts;
import com.ty.textilestockmanagement.repository.SupplierProductsRepository;

@Repository
public class SupplierProductsDao {

	@Autowired
	private SupplierProductsRepository productsRepository;
	
	public SupplierProducts saveSupplierProducts(SupplierProducts products) {
		return productsRepository.save(products);
	}
	
	public SupplierProducts getSupplierProductsById(int id) {
		Optional<SupplierProducts> optional = productsRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public SupplierProducts updateSupplierProducts(SupplierProducts products) {
		Optional<SupplierProducts> optional = productsRepository.findById(products.getId());
		if(optional.isPresent()) {
			return productsRepository.save(products);
		}
		return null;
	}
	
	public String deleteSupplierProducts(int id) {
		Optional<SupplierProducts> optional = productsRepository.findById(id);
		if(optional.isPresent()) {
			productsRepository.deleteById(id);
			return "Deleted record";
		}
		return null;
	}
	
	public List<SupplierProducts> getAllSupplierProducts(){
		return productsRepository.findAll();
	}
}
