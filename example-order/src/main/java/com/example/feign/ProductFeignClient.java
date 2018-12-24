package com.example.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Product;

@FeignClient(value = "example-product")
public interface ProductFeignClient {

	@GetMapping("/product/{id}")
	public Product queryById(@PathVariable("id") Long id);

}
