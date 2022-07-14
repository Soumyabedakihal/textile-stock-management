package com.ty.textilestockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.textilestockmanagement.dto.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
	@Query("SELECT s FROM Shop s WHERE s.email=?1 AND s.password=?2")
	Shop validateShop(String email, String password);
}
