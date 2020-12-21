package cn.bdqn.controller;

import cn.bdqn.entity.Book;
import cn.bdqn.service.IBookClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderOpenFeginController
 * @Description TODO
 * @Date 2020/12/7 15:44
 * @Created by x1c
 */
@RequestMapping("/order2")
@RestController
public class OrderOpenFeginController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private IBookClientService bookClientService; // 当我们从容器里面去取这个接口的实现类时，此时OpenFegin利用JDK生成代理实现类

    @GetMapping("/downOrder/{bookId}")
    public String downOrder(@PathVariable Integer bookId){
        Book book = bookClientService.getBooks(bookId);
        return "下单成功，书籍信息为："+book;
    }
}
