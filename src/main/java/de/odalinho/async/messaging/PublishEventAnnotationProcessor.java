package de.odalinho.async.messaging;

import lombok.val;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Component
public class PublishEventAnnotationProcessor implements MethodInterceptor {

    private final ApplicationEventPublisher eventPublisher;

    public PublishEventAnnotationProcessor(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        val methodReturnValue = invocation.proceed();
        val publishedEvent = getPublishedEvent(invocation);
        val userNotificationEventConstructor = publishedEvent.getUserNotificationEventClass().getConstructor(
                Object.class, publishedEvent.getMessageClass()
        );
        val userNotificationEvent = userNotificationEventConstructor.newInstance(invocation.getThis(),
                methodReturnValue);
        eventPublisher.publishEvent(userNotificationEvent);
        return methodReturnValue;
    }

    private Event getPublishedEvent(MethodInvocation invocation) {
        return AnnotationUtils.getAnnotation(invocation.getMethod(), PublishEvent.class).event();
    }
}