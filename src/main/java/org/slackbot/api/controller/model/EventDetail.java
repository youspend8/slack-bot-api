package org.slackbot.api.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDetail {
    private EventType type;
    private String text;
    private String user;
    private String ts;
    private String team;
    private String channel;
    private List<Map<String, Object>> blocks;

    @JsonProperty("client_msg_id")
    private String clientMsgId;

    @JsonProperty("event_ts")
    private String eventTs;
}
