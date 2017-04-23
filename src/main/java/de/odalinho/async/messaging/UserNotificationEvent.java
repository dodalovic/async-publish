package de.odalinho.async.messaging;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

class UserNotificationEvent<T> extends ApplicationEvent {

    @Getter
    private final T message;

    UserNotificationEvent(Object source, T message) {
        super(source);
        this.message = message;
    }
}
