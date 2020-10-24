package org.slackbot.api.service;

import lombok.RequiredArgsConstructor;
import org.slackbot.api.controller.model.EventReceiveMessage;
import org.slackbot.api.manager.DeployManager;
import org.slackbot.api.model.TextContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    private final DeployManager deployManager;

    public void receive(EventReceiveMessage message) {
        String[] textArr = message.getEvent().getText().split(" ", 3);

        TextContext textContext = new TextContext(textArr);

        switch (textContext.getCommandType()) {
            case DEPLOY:
                deployManager.deploy(textContext.getContent());
        }
    }
}
