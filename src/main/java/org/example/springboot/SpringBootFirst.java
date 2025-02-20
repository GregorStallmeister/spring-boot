package org.example.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SpringBootFirst {

    private List<Message> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String helloSomeone(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @PostMapping("/messages")
    public Message takeMessage(@RequestBody Message message) {
        messages.add(message);

        return message;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }

    @DeleteMapping("/messages/{id}")
    public String deleteByID(@PathVariable String id) {
        for (Message message : messages) {
            if (message.id.equals(id)) {
                messages.remove(message);
                return "Message " + id + " was deleted successfully.";
            }
        }

        return "Message " + id + " was not found.";
    }
}
