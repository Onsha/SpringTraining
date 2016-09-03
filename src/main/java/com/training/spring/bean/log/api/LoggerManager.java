package com.training.spring.bean.log.api;


/**
 * Created by oleksandr
 */
public interface LoggerManager {
    void info(String message);
    void warn(String message);
    void error(String message);
}
