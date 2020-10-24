package org.slackbot.api.manager;

import lombok.RequiredArgsConstructor;
import org.slackbot.api.model.DeployContext;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeployManager {
    private final DeployContext deployContext;

    public void deploy(String content) {
        List<String> splitsList = Arrays.asList(content.split(" "));

        RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication(deployContext.getUsername(), deployContext.getAuthToken())
                .build();

        String url = new StringBuilder()
                .append(deployContext.getBaseURL())
                .append("/job/")
                .append(deployContext.findJobName(splitsList))
                .append("/build?token=")
                .append(deployContext.getBuildToken())
                .toString();

        ResponseEntity<String> result = restTemplate.postForEntity(url, null, String.class);

        System.out.println(result.getBody());
    }
}
