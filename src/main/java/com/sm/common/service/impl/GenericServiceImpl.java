package com.sm.common.service.impl;

import com.sm.common.dao.GenericDao;
import com.sm.common.entity.BaseEntity;
import com.sm.common.query.PageHandler;
import com.sm.common.query.hibernate.Conditions;
import com.sm.common.query.hibernate.Query;
import com.sm.common.service.GenericService;
import org.hibernate.criterion.Projection;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * Created by Newbody on 2016/3/11.
 */
@Transactional
public abstract class GenericServiceImpl<E extends BaseEntity, PK extends Serializable> implements GenericService<E, PK> {

    protected abstract GenericDao<E, PK> getDao();
//    protected Class<E> entityClass;

    public GenericServiceImpl() {
    }

//    @Override
//    public Class<E> getEntityClass() {
//        return entityClass;
//    }

    @Override
    public void save(E entity) {
        getDao().save(entity);
    }

    @Override
    public void save(Collection<E> entities) {
        for (E e : entities){
            save(e);
        }
    }

    @Override
    public void delete(PK id) {
        getDao().delete(id);
    }

    @Override
    public void delete(Collection<PK> ids) {
        for (PK id : ids){
            delete(id);
        }
    }

    @Override
    public void update(E entity) {
        getDao().update(entity);
    }

    @Override
    public void update(Collection<E> entities) {
        for (E e : entities){
            update(e);
        }
    }

    @Override
    public E getById(PK id) {
        return getDao().getById(id);
    }

    @Override
    public E get(Conditions conditions) {
        return getDao().get(conditions);
    }

    @Override
    public List<E> getList() {
        return getDao().getList();
    }

    @Override
    public List<E> getList(Conditions conditions) {
        return getDao().getList(conditions);
    }

    @Override
    public List<E> getList(Query query) {
        return getDao().getList(query);
    }

    @Override
    public PageHandler getPage(Query query) {
        return getDao().getPage(query);
    }

    @Override
    public Object getByProjection(Projection projection) {
        return getDao().getByProjection(projection);
    }

    @Override
    public Object getByProjection(Projection projection, Conditions conditions) {
        return getDao().getByProjection(projection, conditions);
    }
}
