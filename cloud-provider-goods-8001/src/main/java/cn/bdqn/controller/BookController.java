package cn.bdqn.controller;

import cn.bdqn.entity.Book;
import cn.bdqn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname GoodsController
 * @Description TODO
 * @Date 2020/11/30 15:43
 * @Created by x1c
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Value("${server.port}")    // 8001
    private String serverPort;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Autowired
    private IBookService bookService;

    @RequestMapping("/getBooks/{bookId}")
    public Book getBooks(@PathVariable Integer bookId, String color, HttpServletRequest request) {
        Book book = bookService.getBooks(bookId);
        book.setServerPort(serverPort);
        book.setIp(ip);

        String headerStr = request.getHeader("X-Request-Foo");
        book.setServerPort(serverPort+"==="+headerStr+"==="+color);
        return book;
    }
}