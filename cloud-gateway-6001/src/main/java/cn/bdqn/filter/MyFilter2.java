package cn.bdqn.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname MyFilter1
 * @Description TODO
 * @Date 2020/12/14 11:59
 * @Created by x1c
 */

@Slf4j // logback日志支，有了它，无需手动获取logger对象
@Component
public class MyFilter2 implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //鉴权：如果不是没有令牌，不允许范文目标微服务，直接放回404
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            log.info( "token is empty..." );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete(); // 完成响应
        }
        log.info( "token is not empty..." );
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1; // 数值越小，访问优先级越高，then的执行越靠后
    }
}