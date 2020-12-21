package cn.bdqn.service.impl;

import cn.bdqn.entity.Book;
import cn.bdqn.mapper.BookMapper;
import cn.bdqn.service.IBookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Classname BookServiceImpl
 * @Description TODO
 * @Date 2020/12/9 9:43
 * @Created by x1c
 */
@SuppressWarnings("all")
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    /*当达到10s内发起10次请求数且失败率大于等于60%，则服务进行熔断处理
      当出现服务熔断时，会直接导致该服务无法向外提供正常服务，即调用的接口方法只会是回调方法
    * 但经过一段时间（默认为5s），下一次如果还有请求进来，则会尝试进入接口方法，验证是否还报异常，
    如果没有，则服务恢复，否则继续保持服务的熔断
    */
    @Override
    @HystrixCommand(fallbackMethod = "getBookById_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public Book getBooks(Integer bookId) {
        Book book = bookMapper.getBookById(bookId);
        if(book == null){// 模拟异常，便于被Htstrix所监控
            throw new RuntimeException("图书编号【"+bookId+"】查询不到该图书信息！");
        }
        return book;
    }

    public Book getBookById_fallback(Integer bookId) {
        return new Book(bookId,"查询不到该图书信息","",ip+":"+port);
    }
}
