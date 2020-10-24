package org.slackbot.api.beans;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slackbot.api.model.DeployContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
public class ContextConfiguration {
    @Bean
    public DeployContext deployContext() throws IOException {
        JsonNode jsonNode = new ObjectMapper().readTree(
                new PathMatchingResourcePatternResolver()
                        .getResource("classpath:meta.json")
                        .getInputStream());

        return new DeployContext(jsonNode);
    }
}
