package org.slackbot.api.controller.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EventType {
    APP_MENTION;

    @JsonCreator
    public static EventType from(String s) {
        return EventType.valueOf(s.toUpperCase());
    }
}
