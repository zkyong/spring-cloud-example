package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.model.Product;

@Service
public class OrderService {
	private static final Map<String, Order> MAP = new HashMap<>();

	@Autowired
	ProductService productService;

	static {
		String orderId1 = "OID1234567890";
		Order order1 = new Order();
		order1.setOrderId(orderId1);
		order1.setUserId(1L);
		order1.setCreateTime(new Date());
		order1.setUpdateTime(order1.getCreateTime());
		List<OrderDetail> order1Details = new ArrayList<>();
		Product product11 = new Product();
		product11.setId(1L);
		order1Details.add(new OrderDetail(orderId1, product11));
		Product product12 = new Product();
		product12.setId(2L);
		order1Details.add(new OrderDetail(orderId1, product12));
		order1.setOrderDetails(order1Details);
		MAP.put(orderId1, order1);

		String orderId2 = "OID2234567890";
		Order order2 = new Order();
		order2.setOrderId(orderId2);
		order2.setUserId(1L);
		order2.setCreateTime(new Date());
		order2.setUpdateTime(order2.getCreateTime());
		List<OrderDetail> order2Details = new ArrayList<>();
		Product product21 = new Product();
		product21.setId(2L);
		order2Details.add(new OrderDetail(orderId2, product21));
		Product product22 = new Product();
		product22.setId(3L);
		order2Details.add(new OrderDetail(orderId2, product22));
		order2.setOrderDetails(order2Details);
		MAP.put(orderId2, order2);
	}

	/**
	 * 模拟订单查询
	 * 
	 * @param orderId 订单ID
	 * @return Order
	 */
	public Order queryById(String orderId) {
		Order order = MAP.get(orderId);
		if (null == order) {
			return null;
		}
		for (OrderDetail orderDetail : order.getOrderDetails()) {
			Product product = productService.queryById(orderDetail.getProduct().getId());
			if (null == product) {
				continue;
			}
			orderDetail.setProduct(product);
		}
		return order;
	}
}
