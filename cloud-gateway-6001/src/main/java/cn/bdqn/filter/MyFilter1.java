package cn.bdqn.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MyFilter1 implements GlobalFilter, Ordered {

    // exchange: 封装了所有web环境下的servlet对象
    // chain: 过滤链对象，执行filter()方法代表放行到下一个过滤器或者目标微服务
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // startTime
        long startTime = System.currentTimeMillis();
        log.info("filter1-在过滤器前做XX之事"); // XX: 鉴权，日志记录，限流 等等
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long endTime = System.currentTimeMillis();
            log.info("filter1-在过滤器前做OO之事");  // OO: 流量统计 等等
            log.info("URl:"+exchange.getRequest().getURI()+" 耗时:"+(endTime-startTime));
        }));
    }

    @Override
    public int getOrder() {
        return 2; // 数值越小，访问优先级越高，then的执行越靠后
    }
}