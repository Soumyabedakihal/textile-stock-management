package com.ty.textilestockmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilestockmanagement.dto.WareHouse;
import com.ty.textilestockmanagement.repository.WareHouseRepository;

@Repository
public class WareHouseDao {

	@Autowired
	private WareHouseRepository houseRepository;
	
	public WareHouse saveWareHouse(WareHouse house) {
		return houseRepository.save(house);
	}
	
	public WareHouse updateWareHouse(WareHouse house) {
		Optional<WareHouse> optional = houseRepository.findById(house.getId());
		if(optional.isPresent()) {
			return houseRepository.save(house);
		}
		return null;
	}
	
	public String deleteWareHouse(int id) {
		Optional<WareHouse> optional = houseRepository.findById(id);
		if(optional.isPresent()) {
			houseRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not found";
	}
	
	public WareHouse getWareHouseById(int id) {
		Optional<WareHouse> optional = houseRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<WareHouse> getAllWareHouse(){
		return houseRepository.findAll();
	}
}
