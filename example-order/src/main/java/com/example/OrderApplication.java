package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;

@EnableFeignClients     // 启用feign声明式调用
@EnableHystrix          // 启用容错保护
@EnableDiscoveryClient  // 启用服务发现
@SpringBootApplication
public class OrderApplication {

//	@Bean          // 向Spring容器中添加RestTemplate对象
//	@LoadBalanced  // 开启客户端负载均衡
//	public RestTemplate restTemplate() {
//		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
//	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}
