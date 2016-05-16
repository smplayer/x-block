package com.sm.xblock;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by smplayer on 2016/5/16.
 */
@Component
public class SmartSaveKeysToDBListner implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == SaveKeysToDBEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == String.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("testing smart saving keys to database......");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
