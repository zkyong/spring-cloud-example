package com.example.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class ProductService {
	private static final Map<Long, Product> MAP = new HashMap<>();

	static {
		MAP.put(1L, new Product(1L, "商品标题1", "http://图片1.jpg", "商品描述1", new BigDecimal("1000.00")));
		MAP.put(2L, new Product(2L, "商品标题2", "http://图片2.jpg", "商品描述2", new BigDecimal("2000.00")));
		MAP.put(3L, new Product(3L, "商品标题3", "http://图片3.jpg", "商品描述3", new BigDecimal("3000.00")));
		MAP.put(4L, new Product(4L, "商品标题4", "http://图片4.jpg", "商品描述4", new BigDecimal("4000.00")));
		MAP.put(5L, new Product(5L, "商品标题5", "http://图片5.jpg", "商品描述5", new BigDecimal("5000.00")));
		MAP.put(6L, new Product(6L, "商品标题6", "http://图片6.jpg", "商品描述6", new BigDecimal("6000.00")));
		MAP.put(7L, new Product(7L, "商品标题7", "http://图片7.jpg", "商品描述7", new BigDecimal("7000.00")));
		MAP.put(8L, new Product(8L, "商品标题8", "http://图片8.jpg", "商品描述8", new BigDecimal("8000.00")));
		MAP.put(9L, new Product(9L, "商品标题9", "http://图片9.jpg", "商品描述9", new BigDecimal("9000.00")));
	}

	/**
	 * 模拟商品查询
	 * 
	 * @param id 商品ID
	 * @return Product
	 */
	public Product queryById(Long id) {
		Product product = MAP.get(id);
//		product.setDesc("AAAA");
		return product;
	}
}
