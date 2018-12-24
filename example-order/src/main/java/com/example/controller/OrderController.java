package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.JdbcConfig;
import com.example.model.Order;
import com.example.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private JdbcConfig jdbcConfig;

	@GetMapping(value = "/order/{orderId}")
	public Order queryById(@PathVariable("orderId") String orderId) {
		return orderService.queryById(orderId);
	}

	@GetMapping(value = "/order/jdbc")
	public String queryJdbcConfig() {
		return jdbcConfig.toString();
	}
}
