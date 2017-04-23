package de.odalinho.async.messaging;

import de.odalinho.async.model.User;

public class UserUpdatedEvent extends UserNotificationEvent<User> {

    public UserUpdatedEvent(Object source, User user) {
        super(source, user);
    }
}
