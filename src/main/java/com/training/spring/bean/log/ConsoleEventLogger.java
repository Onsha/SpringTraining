package com.training.spring.bean.log;

import com.training.spring.bean.Event;
import com.training.spring.bean.log.api.EventLogger;

/**
 * Created by oleksandr
 */
public class ConsoleEventLogger implements EventLogger {
    public void log(Event event) {
        System.out.println(event);
    }
}
