package com.ty.textilestockmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ShopOrderProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public WareHouse getHouse() {
		return house;
	}

	public void setHouse(WareHouse house) {
		this.house = house;
	}

	public ShopOrder getOrder() {
		return order;
	}

	public void setOrder(ShopOrder order) {
		this.order = order;
	}

	private String product, orderDescription;
	private int quantity;
	
	@OneToOne
	private WareHouse house;
	
	@ManyToOne
	@JoinColumn
	private ShopOrder order;
}