package com.training.spring.bean.log;

import com.training.spring.bean.Event;
import com.training.spring.bean.log.api.EventLogger;
import com.training.spring.bean.log.api.EventType;
import com.training.spring.bean.log.api.LoggerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by oleksandr
 */
public class LoggerManagerImpl implements LoggerManager {
    private Map<EventType, EventLogger> loggers;

    @Autowired
    private ApplicationContext ctx;

    public LoggerManagerImpl(Map<EventType, EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void info(String message) {
        Event event = ctx.getBean(Event.class);
        event.setMessage(message);
        log(event, message);
    }

    public void warn(String message) {
        Event event = ctx.getBean(Event.class);
        event.setType(EventType.WARN);
        log(event, message);

    }

    public void error(String message) {
        Event event = ctx.getBean(Event.class);
        event.setType(EventType.ERROR);
        log(event, message);
    }

    private void log(Event event, String message){
        event.setMessage(message);
        EventLogger suitableLogger = getSuitableLogger(event);
        suitableLogger.log(event);
    }

    private EventLogger getSuitableLogger(Event event){
        return loggers.get(event.getType());
    }
}
