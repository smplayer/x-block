package com.sm.xblock.dao;

import com.sm.common.dao.GenericDao;
import com.sm.xblock.entity.Key;

import java.util.List;

/**
 * Created by smplayer on 2016/5/3.
 */
public interface KeyDao extends GenericDao<Key, String> {
    void saveKeys(List<String> keys);
}
