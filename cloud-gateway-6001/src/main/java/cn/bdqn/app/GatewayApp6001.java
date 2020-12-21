package cn.bdqn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname GatewayApp6001
 * @Description TODO
 * @Date 2020/12/11 16:10
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableDiscoveryClient //开启Consul注册发现
public class GatewayApp6001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp6001.class,args);
    }
}
