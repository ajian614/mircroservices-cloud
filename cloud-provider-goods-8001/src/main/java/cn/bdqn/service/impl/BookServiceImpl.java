package cn.bdqn.service.impl;

import cn.bdqn.entity.Book;
import cn.bdqn.mapper.BookMapper;
import cn.bdqn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Book getBooks(Integer bookId) {
        return bookMapper.getBookById(bookId);
    }
}
