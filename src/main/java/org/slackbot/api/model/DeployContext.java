package org.slackbot.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@ToString
@Getter
public class DeployContext {
    private String username;
    private String authToken;
    private String baseURL;
    private String buildToken;
    private JsonNode services;

    public DeployContext(JsonNode jsonNode) {
        JsonNode node = jsonNode.findPath("deploy");
        this.username = node.findPath("username").asText();
        this.authToken = node.findPath("auth_token").asText();
        this.baseURL = node.findPath("base_url").asText();
        this.buildToken = node.findPath("build_token").asText();
        this.services = node.findPath("services");
    }

    public String findJobName(List<String> splitsList) {
        JsonNode node = this.services;
        for (String s : splitsList) {
            node = node.findPath(s);
        }
        return Optional.ofNullable(node.get("job_name"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Arguments"))
                .asText();
    }
}
