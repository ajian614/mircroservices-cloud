package cn.bdqn.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GateWayConfig
 * @Description TODO
 * @Date 2020/12/14 9:45
 * @Created by x1c
 */
@Configuration
public class GateWayConfig {
    // IE: http://localhost:6001/guonei  => http://news.baidu.com/guonei
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("path_route1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).route("path_route2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("path_route3",
                r -> r.path("/mil")
                        .uri("http://news.baidu.com/mil")).build();
    }
}
