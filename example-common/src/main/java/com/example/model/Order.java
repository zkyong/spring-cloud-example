package com.example.model;

import java.util.Date;
import java.util.List;

public class Order {
	private String orderId;
	private Long userId;
	private Date createTime;
	private Date updateTime;
	private List<OrderDetail> orderDetails;

	public Order() {
		super();
	}

	public Order(String orderId, Long userId, Date createTime, Date updateTime) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", orderDetails=" + orderDetails + "]";
	}

}
