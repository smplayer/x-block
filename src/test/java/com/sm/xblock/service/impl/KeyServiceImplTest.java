package com.sm.xblock.service.impl;

import com.sm.xblock.service.KeyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by smplayer on 2016/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:defaultDispatcher-servlet.xml", "classpath:applicationContext.xml"})
//@TransactionConfiguration(defaultRollback = false)
@Transactional
public class KeyServiceImplTest {
    @Autowired
    private KeyService keyService;

    @Test
    public void saveKeysToDB() throws Exception {
        keyService.saveKeysToDB();
    }
}