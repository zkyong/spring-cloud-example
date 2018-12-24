package com.example.model;

public class OrderDetail {
	private String orderId;
	private Product product = new Product();

	public OrderDetail() {
		super();
	}

	public OrderDetail(String orderId, Product product) {
		super();
		this.orderId = orderId;
		this.product = product;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", product=" + product + "]";
	}

}
