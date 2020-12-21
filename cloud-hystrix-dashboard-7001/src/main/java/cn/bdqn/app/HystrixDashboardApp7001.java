package cn.bdqn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname HystrixDashboardApp7001
 * @Description TODO
 * @Date 2020/12/11 13:52
 * @Created by x1c
 */

@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableHystrixDashboard
public class HystrixDashboardApp7001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp7001.class,args);
    }
}
