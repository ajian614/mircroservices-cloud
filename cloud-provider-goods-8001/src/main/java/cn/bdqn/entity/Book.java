package cn.bdqn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2020/12/7 14:44
 * @Created by x1c
 */
@Component
@Data   // 自动为我们生产了setter/getter  ... @EqualsAndHashCode @Tostring
@NoArgsConstructor //生产无参构造方法
@AllArgsConstructor // 它生产一个带有所有属性的有参构造方法
public class Book {
    private Integer bookId;
    private String bookName;

    private String ip;
    private String serverPort;

}
