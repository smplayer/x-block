package com.sm.xblock;

import org.springframework.context.ApplicationEvent;

/**
 * Created by smplayer on 2016/5/16.
 */
public class SaveKeysToDBEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SaveKeysToDBEvent(Object source) {
        super(source);
    }
}
