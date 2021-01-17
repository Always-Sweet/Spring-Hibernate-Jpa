package com.demo.dao;

import com.demo.domain.Book;
import com.demo.model.PageParam;
import com.demo.model.PageResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
     */
    public PageResult find(PageParam pageParam) {
        int offset = (pageParam.getPageNum() - 1) * pageParam.getPageSize();
        int limit = pageParam.getPageSize();
        String hql = " from Book ";
        Query query = getSession().createQuery(hql);
        List<Book> result = new ArrayList();
        if ("2".equals(pageParam.getPageReturnType())) {
            query.setFirstResult(offset);
            query.setMaxResults(limit);
        }
        result = query.list();
        return new PageResult(pageParam.getPageSize(), result);
    }

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
