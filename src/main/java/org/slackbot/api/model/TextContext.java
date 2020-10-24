package org.slackbot.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TextContext {
    private String target;
    private CommandType commandType;
    private String content;

    public TextContext(String[] splits) {
        if (splits.length < 3) {
            throw new IllegalArgumentException("Splits length most be at least 2");
        }
        this.target = splits[0];
        this.commandType = CommandType.from(splits[1].toUpperCase());
        this.content = splits[2];
    }
}
