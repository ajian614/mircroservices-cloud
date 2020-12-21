package cn.bdqn.factory;

import cn.bdqn.entity.Book;
import cn.bdqn.service.IBookClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname BookClientServiceFallbackFactory
 * @Description TODO
 * @Date 2020/12/9 11:45
 * @Created by x1c
 */

@Component
public class BookClientServiceFallbackFactory implements FallbackFactory<IBookClientService> {
    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Override
    public IBookClientService create(Throwable throwable) {
        return new IBookClientService() {
            @Override
            public Book getBooks(Integer bookId) {
                return new Book(bookId,"查询不到该图书信息消费者提供的降级信息，此刻服务提供者已经关闭，请稍后重试！",ip, port);
            }
        };
    }
}