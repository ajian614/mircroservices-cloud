package cn.bdqn.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationContextConfig
 * @Description TODO
 * @Date 2020/11/30 16:16
 * @Created by x1c
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  // @开启负载均衡功能，@把我们的访问接口的服务URL，通过URl里面的服务名称给转换成对应的ip+port
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
