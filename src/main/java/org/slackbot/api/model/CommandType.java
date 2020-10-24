package org.slackbot.api.model;

import java.util.Optional;

public enum CommandType {
    DEPLOY;

    public static CommandType from(String s) {
        return Optional.of(CommandType.valueOf(s.toUpperCase()))
                .orElseThrow(IllegalArgumentException::new);
    }
}
