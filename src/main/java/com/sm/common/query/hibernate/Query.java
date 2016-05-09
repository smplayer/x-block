package com.sm.common.query.hibernate;

import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

import static com.sm.common.config.PagingConfig.DEFAULT_PAGE_SIZE;
import static com.sm.common.config.PagingConfig.MAX_PAGE_SIZE;

/**
 * Created by Newbody on 2016/2/28.
 */
public class Query {
    private Conditions conditions;
    private List<Order> orderList = new ArrayList<>();
    private Long pageIndex = 1L;
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    public Conditions getConditions() {
        return conditions;
    }

    public Query setConditions(Conditions conditions) {
        this.conditions = conditions;
        return this;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Long getPageIndex() {
        return  1 > pageIndex ? 1 : pageIndex;
    }

    public Query setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public Integer getPageSize() {
        return 1 > pageSize ? DEFAULT_PAGE_SIZE : MAX_PAGE_SIZE < pageSize ? MAX_PAGE_SIZE : pageSize;
    }

    public Query setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Long getDataIndex() {
        return (pageIndex - 1) * pageSize;
    }

    public Query addOrder(Order order){
        this.orderList.add(order);
        return this;
    }

}
