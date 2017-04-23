package de.odalinho.async.messaging;

import de.odalinho.async.model.User;

public enum Event {

    USER_CREATED {
        @Override
        public Class<?> getMessageClass() {
            return User.class;
        }

        @Override
        public Class<? extends UserNotificationEvent> getUserNotificationEventClass() {
            return UserCreatedEvent.class;
        }
    },
    USER_UPDATED {
        @Override
        public Class<?> getMessageClass() {
            return User.class;
        }

        @Override
        public Class<? extends UserNotificationEvent> getUserNotificationEventClass() {
            return UserUpdatedEvent.class;
        }
    };

    public abstract Class<?> getMessageClass();

    public abstract Class<? extends UserNotificationEvent> getUserNotificationEventClass();
}
