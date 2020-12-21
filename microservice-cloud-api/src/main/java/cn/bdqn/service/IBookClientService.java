package cn.bdqn.service;

import cn.bdqn.entity.Book;
import cn.bdqn.factory.BookClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname IBookClientService
 * @Description TODO
 * @Date 2020/12/7 15:00
 * @Created by x1c
 */
// 告诉OpenFeign四个东东，它就可以借助jdk来为当前这个接口生产代理实现类，(http://ip:port/)
// 等价于Ribbon+RestTemplate曾经写过的代码

@FeignClient(value="cloud-provider-goods",fallbackFactory = BookClientServiceFallbackFactory.class)  // 告诉Openfegin服务名
@RequestMapping("/book")
public interface IBookClientService {

    // OpenFegin它天然支持SpringMVC注解，可以很方便我们直接利用这些注解告知它对应的服务接口路径
    // Ps: 如果用到了ant风格的URL,注意该方法的形参上标注的注解@PathVariable里面必须写好value

    // 该方法的返回值就是调用了对应接口所方会的对象类型
    @RequestMapping("/getBooks/{bookId}")
    public Book getBooks(@PathVariable(value = "bookId") Integer bookId);
}
