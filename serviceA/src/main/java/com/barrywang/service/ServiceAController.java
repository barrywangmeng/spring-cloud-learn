package com.barrywang.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务A的接口
 * @author wangmeng
 *
 */
@RestController
public class ServiceAController {

	@RequestMapping(value = "/sayHello/{name}", 
			method = RequestMethod.GET)
	public String sayHello(@PathVariable("name") String name) {
		System.out.println("被调用了一次");  
		return "{'msg': 'hello, " + name + "'}";  
	}

    @RequestMapping(value = "/sayBey/{name}",
            method = RequestMethod.GET)
    public String sayBey(@PathVariable("name") String name) {
        System.out.println("被调用了一次");
        return "{'msg': 'bye, " + name + "'}";
    }
}