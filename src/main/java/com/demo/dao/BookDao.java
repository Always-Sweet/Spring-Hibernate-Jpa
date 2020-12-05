package com.demo.dao;

import com.demo.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
     * 获取图书
     *
     * @param id
     */
    public Book get(String id) {
        String hql = " from Book where id = :id ";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        return (Book) query.uniqueResult();
    }

    /**
     * 添加图书
     *
     * @param book
     */
    public void save(Book book) {
        getSession().save(book);
    }

    /**
     * 更新图书信息
     *
     * @param book
     */
    public void update(Book book) {
        getSession().update(book);
    }

    /**
     * 删除图书
     *
     * @param book
     */
    public void remove(Book book) {
        getSession().delete(book);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
