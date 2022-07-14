package com.ty.textilestockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.textilestockmanagement.dto.ShopOrder;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, Integer>{

}
