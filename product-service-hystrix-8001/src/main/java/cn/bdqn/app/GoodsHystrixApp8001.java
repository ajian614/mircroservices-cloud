package cn.bdqn.app;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @Classname App
 * @Description TODO
 * @Date 2020/11/30 15:37
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableDiscoveryClient //能够让注册中心发现，并扫描到该服务（我们的项目）
@MapperScan("cn.bdqn.mapper")
@EnableCircuitBreaker
public class GoodsHystrixApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsHystrixApp8001.class,args);
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
