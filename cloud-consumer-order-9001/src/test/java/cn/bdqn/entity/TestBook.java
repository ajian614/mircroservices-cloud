package cn.bdqn.entity;

import cn.bdqn.app.OrderApp9001;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname TestBook
 * @Description TODO
 * @Date 2020/12/7 14:46
 * @Created by x1c
 */
@SpringBootTest(classes = OrderApp9001.class)
public class TestBook {
    @Autowired
    private Book book;

    @Test
    void test1() {
        book.toString();
    }
}
