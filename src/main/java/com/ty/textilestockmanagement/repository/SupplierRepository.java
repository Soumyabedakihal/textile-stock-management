package com.ty.textilestockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.textilestockmanagement.dto.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	@Query("SELECT s FROM Supplier s WHERE s.email=?1 AND s.password=?2")
	Supplier validateSupplier(String email, String password);
}
