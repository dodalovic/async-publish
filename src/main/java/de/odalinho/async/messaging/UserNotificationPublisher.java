package de.odalinho.async.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserNotificationPublisher implements ApplicationListener<UserNotificationEvent> {

    @Override
    public void onApplicationEvent(UserNotificationEvent event) {
        log.info("UserNotificationPublisher::Thread.currentThread().getName() = " + Thread.currentThread().getName());
        log.info("UserNotificationPublisher::event.getMessage() = " + event.getMessage());
    }
}
