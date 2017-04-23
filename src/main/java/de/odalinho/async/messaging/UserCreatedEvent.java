package de.odalinho.async.messaging;

import de.odalinho.async.model.User;

public class UserCreatedEvent extends UserNotificationEvent<User> {

    public UserCreatedEvent(Object source, User user) {
        super(source, user);
    }
}
