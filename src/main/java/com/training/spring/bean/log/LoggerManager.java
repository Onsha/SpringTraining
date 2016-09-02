package com.training.spring.bean.log;

import com.training.spring.bean.Event;
import com.training.spring.bean.log.api.EventLogger;

import java.util.Collection;

/**
 * Created by oleksandr
 */
public class LoggerManager implements EventLogger {
    private Collection<EventLogger> loggers;

    public LoggerManager(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void log(Event event) {
        for(EventLogger logger : loggers){
            logger.log(event);
        }
    }
}
