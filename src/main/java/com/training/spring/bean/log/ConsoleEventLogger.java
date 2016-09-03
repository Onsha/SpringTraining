package com.training.spring.bean.log;

import com.training.spring.bean.Event;

/**
 * Created by oleksandr
 */
public class ConsoleEventLogger extends AbstractLogger {
    public void log(Event event) {
        System.out.println(event.getFormattedDate() + LOG_SEPARATOR +
                getPlace() + event);
    }
}
