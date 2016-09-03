package com.training.spring.bean.log;

import com.training.spring.bean.log.api.EventLogger;

/**
 * Created by oleksandr
 */
public abstract class AbstractLogger  implements EventLogger {
    public static final String LOG_SEPARATOR = " - ";
    public static final String DASH = "#";
    public static final String PREFIX_AT_LINE = "() at line ";
    protected String getPlace(){
        StackTraceElement stack = Thread.currentThread().getStackTrace()[5];
        return stack.getClassName() + DASH +
                stack.getMethodName() + PREFIX_AT_LINE +
                stack.getLineNumber();
    }
}
