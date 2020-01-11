package com.barrywang.service;

import com.barrywang.service.feign.ServiceAFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Configurat
@RestController
@RequestMapping("/user")
public class ServiceBController {

//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}
//
//	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
//	public String greeting(@PathVariable("name") String name) {
//		RestTemplate restTemplate = getRestTemplate();
//		return restTemplate.getForObject("http://ServiceA/sayHello/" + name, String.class);
//	}

    @Autowired
    private ServiceAFeignClient serviceAFeignClient;

    @RequestMapping(value = "/feign/greeting/{name}", method = RequestMethod.GET)
    public String greetingWithFeign(@PathVariable("name") String name) {
        return serviceAFeignClient.sayHello(name);
    }

    @RequestMapping(value = "/feign/sayBye/{name}", method = RequestMethod.GET)
    public String sayBye(@PathVariable("name") String name) {
        return serviceAFeignClient.sayBye(name);
    }
}
