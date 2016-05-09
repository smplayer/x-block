package com.sm.xblock.dao;

import com.sm.common.dao.impl.HibernateGenericDaoImpl;
import com.sm.xblock.entity.Key;
import org.springframework.stereotype.Repository;

/**
 * Created by smplayer on 2016/5/4.
 */
@Repository("keyDao")
public class KeyDaoImpl extends HibernateGenericDaoImpl<Key, String> implements KeyDao {
}
