package cn.bdqn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname OrderApp9001
 * @Description TODO
 * @Date 2020/12/4 10:10
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.bdqn.service"})
public class OrderApp9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp9001.class,args);
    }
}
