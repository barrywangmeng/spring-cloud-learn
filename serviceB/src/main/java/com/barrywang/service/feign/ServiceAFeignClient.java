package com.barrywang.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangmeng
 * @since 2019-08-21
 */
@FeignClient(name = "serviceA")
public interface ServiceAFeignClient {

    /**
     * feign 接口调用
     */
    @GetMapping(path = "/sayHello/{name}")
    String sayHello(@PathVariable("name") String name);
}