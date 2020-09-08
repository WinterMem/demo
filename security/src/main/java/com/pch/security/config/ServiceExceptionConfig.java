package com.pch.security.config;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * spring 各种监听器{@link ApplicationPreparedEvent} {@link ApplicationReadyEvent}
 * </p>
 *
 * @author pch
 */
@Configuration
public class ServiceExceptionConfig {

//    @EventListener(ApplicationReadyEvent.class)
//    public void initApplicationReadyEvent() {
//        System.err.println("initApplicationReadyEvent");
//    }
//
//    @EventListener(ApplicationStartingEvent.class)
//    public void initApplicationStartingEvent() {
//        System.err.println("initApplicationStartingEvent");
//    }
//
//    @EventListener(ApplicationStartedEvent.class)
//    public void initApplicationStartedEvent() {
//        System.err.println("initApplicationStartedEvent");
//    }
//
//    @EventListener(ApplicationPreparedEvent.class)
//    public void initApplicationPreparedEvent() {
//        System.err.println("initApplicationPreparedEvent");
//    }
}
