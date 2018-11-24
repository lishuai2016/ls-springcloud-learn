package com.ls;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lishuai
 * @CreateDate: 2018/11/21 11:06
当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。
Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。
通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
仅仅@EnableEurekaClient是不够的，还需要在配置文件中注明自己的服务注册中心的地址
 */
//@SpringBootApplication
//@EnableEurekaClient
//@RestController
//public class ServiceHiApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run( ServiceHiApplication.class, args );
//    }
//
//    @Value("${server.port}")
//    String port;
//
//    @RequestMapping("/hi")
//    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
//        return "hi " + name + " ,i am from port:" + port;
//    }
//
//}

/**
 * Hystrix Dashboard版本
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceHiApplication {

    /**
     * 访问地址 http://localhost:8762/actuator/hystrix.stream
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run( ServiceHiApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}

