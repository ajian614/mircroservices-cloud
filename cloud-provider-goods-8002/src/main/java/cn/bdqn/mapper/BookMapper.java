package cn.bdqn.mapper;

import cn.bdqn.entity.Book;

/**
 * @Classname BookMapper
 * @Description TODO
 * @Date 2020/12/9 9:39
 * @Created by x1c
 */

public interface BookMapper {
    public Book getBookById(Integer bookId);
}
