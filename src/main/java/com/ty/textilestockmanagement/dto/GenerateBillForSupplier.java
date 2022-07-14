package com.ty.textilestockmanagement.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GenerateBillForSupplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBillgenetate() {
		return billgenetate;
	}
	public void setBillgenetate(int billgenetate) {
		this.billgenetate = billgenetate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	private int billgenetate = (int)(Math.random() * 1000000), total;
	private LocalDateTime dateTime;
	//orderid
	//orderproducts
}
