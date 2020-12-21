package cn.bdqn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname CloudConfigClient5002
 * @Description TODO
 * @Date 2020/12/22 1:04
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableDiscoveryClient
public class CloudConfigClient5002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient5002.class,args);
    }
}
