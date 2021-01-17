package com.demo.service;

import com.demo.dao.BookDao;
import com.demo.domain.Book;
import com.demo.exception.LogicException;
import com.demo.model.PageParam;
import com.demo.model.PageResult;
import com.demo.utils.ToolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * 书库service
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 获取图书信息
     */
    public PageResult find(PageParam pageParam) {
        return bookDao.find(pageParam);
    }

    /**
     * 获取图书信息
     *
     * @param id
     */
    public Book get(String id) {
        return bookDao.get(id);
    }

    /**
     * 添加图书
     *
     * @param book
     */
    public void saveBook(Book book) {
        book.setId(null);
        book.setStorageDate(new Date());
        bookDao.save(book);
    }

    /**
     * 更新图书信息
     *
     * @param book
     */
    public void updateBook(Book book) throws LogicException {
        Book search = bookDao.get(book.getId());
        if (search == null) throw new LogicException("更新图书不存在");
        ToolUtils.copyPropertiesIgnoreNull(book, search);
        bookDao.update(search);
    }

    /**
     * 删除图书
     *
     * @param id
     */
    public void removeBook(String id) throws LogicException {
        Book search = bookDao.get(id);
        if (search == null) throw new LogicException("删除图书不存在：" + id);
        bookDao.remove(search);
    }
}
