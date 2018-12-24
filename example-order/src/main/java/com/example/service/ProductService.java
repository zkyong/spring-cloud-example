package com.example.service;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.client.RestTemplate;

import com.example.feign.ProductFeignClient;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.example.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductService {

//	@Autowired
//	RestTemplate restTemplate;
//	@Autowired
//	DiscoveryClient discoveryClient;
	@Autowired
	ProductFeignClient productFeignClient;
	
	/**
	 * 模拟商品查询
	 * 
	 * 方式四：通过feign方式调用
	 * @param id 商品ID
	 * @return Product
	 */
	@HystrixCommand(fallbackMethod = "queryByIdFallbackMethod")
	public Product queryById(Long id) {
		return productFeignClient.queryById(id);
	}
	
	/**
	 * 模拟商品查询
	 * 
	 * 方式三：负载均衡方式调用
	 * @param id 商品ID
	 * @return Product
	 */
//	@HystrixCommand(fallbackMethod = "queryByIdFallbackMethod")
//	public Product queryById(Long id) {
//		String serviceId = "example-product";
//		String url = "http://" + serviceId + "/product/" + id;
//		return restTemplate.getForObject(url, Product.class);
//	}
	
	/**
	 * 模拟商品查询
	 * 
	 * 方式二：通过serviceId调用
	 * @param id 商品ID
	 * @return Product
	 */
//	public Product queryById(Long id) {
//		String serviceId = "example-product";
//		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//		if (CollectionUtils.isEmpty(instances)) {
//			return null;
//		}
//		ServiceInstance instance = instances.get(0);
//		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + id;
//		return restTemplate.getForObject(url, Product.class);
//	}
	
	/**
	 * 模拟商品查询
	 * 
	 * 方式一：直接通过URL调用
	 * @param id 商品ID
	 * @return Product
	 */
//	public Product queryById(Long id) {
//		String url = "http://127.0.0.1:6810/product/" + id;
//		return restTemplate.getForObject(url, Product.class);
//	}
	
	/**
	 * 商品查询出错处理方法，返回值要保持一致
	 * 
	 * @param id 商品ID
	 * @return Product
	 */
	public Product queryByIdFallbackMethod(Long id) {
		return new Product(id, null, null, "查询商品信息出错", null);
	}
}
