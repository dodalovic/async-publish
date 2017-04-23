package de.odalinho.async;

import de.odalinho.async.messaging.PublishEvent;
import de.odalinho.async.model.User;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static de.odalinho.async.messaging.Event.USER_CREATED;
import static de.odalinho.async.messaging.Event.USER_UPDATED;

@RestController
@Slf4j
public class PublishingController {

    @PublishEvent(event = USER_CREATED)
    @GetMapping("/users/{userId}")
    User getUser(@PathVariable int userId) {
        val user = new User().setId(userId).setAge(33).setName("Some name");
        log.info("PublishingController::Thread.currentThread().getName() = " + Thread.currentThread().getName());
        return user;
    }

    @PublishEvent(event = USER_UPDATED)
    @PostMapping(value = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@PathVariable int userId, @RequestBody User user) {
        log.info("PublishingController::Thread.currentThread().getName() = " + Thread.currentThread().getName());
        return user;
    }
}
