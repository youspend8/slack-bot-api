package org.slackbot.api.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventReceiveMessage {
    @JsonProperty("token")
    private String token;

    @JsonProperty("team_id")
    private String teamId;

    @JsonProperty("api_app_id")
    private String apiAppId;

    @JsonProperty("event")
    private EventDetail event;

    @JsonProperty("challenge")
    private String challenge;

    @JsonProperty("is_ext_shared_channel")
    private boolean isExtSharedChannel;

    private String type;
    private String eventId;
    private String eventTime;
    private String eventContext;
}
