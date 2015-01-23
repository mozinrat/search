package com.erecyclingcorps.exceptionhandler;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler  implements AsyncUncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        LOGGER.error("Exception message - " + throwable.getMessage());
        LOGGER.error("Method name - " + method.getName());
        for (Object param : obj) {
            LOGGER.error("Parameter value - " + param);
        }
    }

}