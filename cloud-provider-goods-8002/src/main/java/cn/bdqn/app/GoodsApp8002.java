package cn.bdqn.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname App
 * @Description TODO
 * @Date 2020/11/30 15:37
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableDiscoveryClient //能够让注册中心发现，并扫描到该服务（我们的项目）
@MapperScan("cn.bdqn.mapper")
public class GoodsApp8002 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApp8002.class,args);
    }
}
