package com.sm.common.dao.impl;

import com.sm.common.Base;
import com.sm.common.dao.GenericDao;
import com.sm.common.entity.BaseEntity;
import com.sm.common.query.hibernate.Conditions;
import com.sm.common.query.PageHandler;
import com.sm.common.query.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * Created by Newbody on 2016/2/28.
 */
//@Transactional
public abstract class HibernateGenericDaoImpl<E extends BaseEntity, PK extends Serializable> extends Base implements GenericDao<E, PK> {
    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;
    protected Class<E> entityClass;

    public HibernateGenericDaoImpl() {
        Class c = getClass();
        ParameterizedType ptype = null;
        do { // 遍历所有超类，直到找泛型定义
            try {
                ptype = (ParameterizedType) c.getGenericSuperclass();
            } catch (Exception e) {
            }
            c = c.getSuperclass();
        } while (ptype == null && c != null);
        if (ptype == null) {
            System.out.println("子类中没有定义泛型的具体类型");
        } else {
            this.entityClass = (Class<E>) ptype.getActualTypeArguments()[0];
        }
    }

    public HibernateGenericDaoImpl(Class<E> entityClass){
        this.entityClass = entityClass;
    }

    @Override
    public void save(E entity) {
        getSession().save(entity);
    }

    @Override
    public void save(Collection<E> entities) {
        for (E e : entities){
            this.save(e);
        }
    }

    @Override
    public void delete(PK id) {
        Session session = getSession();
        E e = getById(id);
        session.delete(e);
    }

    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    public void update(Collection<E> entities) {
        for (E e : entities) {
            this.update(e);
        }
    }

    @Override
    public E getById(PK id) {
        return (E) getSession().get(getEntityClass(), id);
    }

    @Override
    public E get(Conditions conditions) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        for (Criterion criterion : conditions.getCriterionList()){
            criteria.add(criterion);
        }
        return (E) criteria.uniqueResult();
    }

    @Override
    public List<E> getList() {
        return getSession().createCriteria(getEntityClass()).list();
    }

    @Override
    public List<E> getList(Conditions conditions) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        for (Criterion criterion : conditions.getCriterionList()){
            criteria.add(criterion);
        }
        return criteria.list();
    }

    @Override
    public List<E> getList(Query query) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        Conditions conditions = query.getConditions();
        for (Criterion criterion : conditions.getCriterionList()){
            criteria.add(criterion);
        }
        for (Order order : query.getOrderList()){
            criteria.addOrder(order);
        }
        return criteria.list();
    }

    @Override
    public PageHandler getPage(Query query) {
        PageHandler page = new PageHandler();
        page.setPageIndex(query.getPageIndex());
        page.setPageSize(query.getPageSize());

        Criteria criteria = getSession().createCriteria(getEntityClass());

        Conditions conditions = query.getConditions();
        for (Criterion criterion : conditions.getCriterionList()){
            criteria.add(criterion);
        }

        criteria.setProjection(Projections.rowCount());
        page.setDataQuantity((Long)criteria.uniqueResult());

        criteria.setProjection(null)
        .setFirstResult(query.getDataIndex().intValue())
        .setMaxResults(query.getPageSize());
        for (Order order : query.getOrderList()){
            criteria.addOrder(order);
        }

        page.setDataList(criteria.list());

        return page;
    }

    @Override
    public Object getByProjection(Projection projection){
        Criteria criteria = getSession().createCriteria(getEntityClass());
        criteria.setProjection(projection);
        return criteria.uniqueResult();
    }

    @Override
    public Object getByProjection(Projection projection, Conditions conditions){
        Criteria criteria = getSession().createCriteria(getEntityClass());
        criteria.setProjection(projection);
        for (Criterion criterion : conditions.getCriterionList()){
            criteria.add(criterion);
        }
        return criteria.uniqueResult();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Class<E> getEntityClass() {
        return this.entityClass;
    }

//    public void setEntityClass(Class<E> entityClass) {
//        this.entityClass = entityClass;
//    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}
