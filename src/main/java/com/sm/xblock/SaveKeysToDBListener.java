package com.sm.xblock;

import com.sm.xblock.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by smplayer on 2016/5/16.
 */
@Component
public class SaveKeysToDBListener implements ApplicationListener<SaveKeysToDBEvent> {
    @Autowired
    private KeyService keyService;

    @Override
    public void onApplicationEvent(SaveKeysToDBEvent event) {
        System.out.println("saving keys to database......");
    }
}
