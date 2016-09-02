package com.training.spring.bean.log.api;

import com.training.spring.bean.Event;

/**
 * Created by oleksandr
 */
public interface EventLogger {
    void log(Event event);
}
