package com.barrywang.service.feign;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * ServiceA远程调用fallBack工厂类
 *
 * @author wangmeng
 * @since 2020-01-11
 */
@Component
public class ServiceAFallbackFactory implements FallbackFactory<ServiceAFeignClient> {
    @Override
    public ServiceAFeignClient create(Throwable throwable) {
        return new ServiceAFeignClient() {
            @Override
            public String sayHello(String name) {
                System.out.println("sayHello降级了。。。。");
                return null;
            }

            @Override
            public String sayBye(String name) {
                System.out.println("sayBye降级了。。。。");
                return null;
            }
        };
    }
}
