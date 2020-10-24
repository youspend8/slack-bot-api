package org.slackbot.api.controller;

import lombok.RequiredArgsConstructor;
import org.slackbot.api.controller.model.EventReceiveMessage;
import org.slackbot.api.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping(value = "/receive")
    public String receive(
            @RequestBody EventReceiveMessage message) {
        System.out.println(message);
        eventService.receive(message);
        return message.getChallenge();
    }
}
