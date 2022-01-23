package com.barrywang.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangmeng
 * @since 2019-08-21
 */
@FeignClient(name = "serviceA", fallbackFactory = ServiceAFallbackFactory.class)
public interface ServiceAFeignClient {

    /**
     * feign 接口调用
     */
    @GetMapping(path = "/sayHello/{name}")
    String sayHello(@PathVariable("name") String name);

    /**
     * feign 接口调用
     */
    @GetMapping(path = "/sayBye/{name}")
    String sayBye(@PathVariable("name") String name);
}
