package com.sm.xblock.service;

import com.sm.common.service.GenericService;
import com.sm.xblock.entity.Key;

/**
 * Created by smplayer on 2016/5/4.
 */
public interface KeyService extends GenericService<Key, String> {

    void generate(Integer length);

    void saveKeysToDB();

}
