package com.sm.common.service;

import com.sm.common.entity.BaseEntity;
import com.sm.common.query.PageHandler;
import com.sm.common.query.hibernate.Conditions;
import com.sm.common.query.hibernate.Query;
import org.hibernate.criterion.Projection;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Newbody on 2016/3/11.
 */
public interface GenericService<E extends BaseEntity, PK extends Serializable> {
//    Class<E> getEntityClass();
    void save(E entity);
    void save(Collection<E> entities);
    void delete(PK id);
    void delete(Collection<PK> ids);
    void update(E entity);
    void update(Collection<E> entities);
    E getById(PK id);
    E get(Conditions conditions);
    List<E> getList();
    List<E> getList(Conditions conditions);
    List<E> getList(Query query);
    PageHandler getPage(Query query);
    Object getByProjection(Projection projection);
    Object getByProjection(Projection projection, Conditions conditions);
}
