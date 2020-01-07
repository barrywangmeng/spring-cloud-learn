package com.barrywang.service;

import com.barrywang.service.feign.ServiceAFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class ServiceBController {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
    private ServiceAFeignClient serviceAFeignClient;

	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
	public String greeting(@PathVariable("name") String name) {
		RestTemplate restTemplate = getRestTemplate();
		return restTemplate.getForObject("http://ServiceA/sayHello/" + name, String.class);
	}

    @RequestMapping(value = "/feign/greeting/{name}", method = RequestMethod.GET)
    public String greetingWithFeign(@PathVariable("name") String name) {
        return serviceAFeignClient.sayHello(name);
    }

    @RequestMapping(value = "/feign/greeting/{name}", method = RequestMethod.GET)
    public String sayBye(@PathVariable("name") String name) {
        return serviceAFeignClient.sayBye(name);
    }
}
