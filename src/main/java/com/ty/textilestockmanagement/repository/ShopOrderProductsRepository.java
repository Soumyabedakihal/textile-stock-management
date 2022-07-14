package com.ty.textilestockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.textilestockmanagement.dto.ShopOrderProducts;

public interface ShopOrderProductsRepository extends JpaRepository<ShopOrderProducts, Integer> {

}
