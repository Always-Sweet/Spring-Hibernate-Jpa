package com.demo.service;

import com.demo.dao.BookDao;
import com.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 书库service
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 添加图书
     *
     * @param book
     */
    public void saveBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        book.setStorageDate(new Date());
        bookDao.save(book);
    }
}
