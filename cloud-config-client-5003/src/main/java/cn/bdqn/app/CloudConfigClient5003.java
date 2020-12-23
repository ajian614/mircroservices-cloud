package cn.bdqn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname CloudConfigClient5003
 * @Description TODO
 * @Date 2020/12/23 10:10
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableDiscoveryClient
public class CloudConfigClient5003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient5003.class,args);
    }
}
