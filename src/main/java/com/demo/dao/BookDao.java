package com.demo.dao;

import com.demo.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * 书库dao
 */
@Repository
@Transactional
public class BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 添加图书
     *
     * @param book
     */
    public void save(Book book) {
        getSession().save(book);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
