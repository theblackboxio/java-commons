package io.theblackbox.commons.integration.slack.autoconfigure;

import io.theblackbox.commons.integration.slack.SlackService;
import io.theblackbox.commons.integration.slack.SlackSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by guillermoblascojimenez on 08/11/16.
 */
@Configuration
@ConditionalOnMissingBean({SlackSimpleService.class, SlackService.class})
@EnableConfigurationProperties(SlackProperties.class)
public class SlackServiceAutoConfiguration {


    @Autowired
    private SlackProperties properties;
    @Autowired(required = false)
    private RestTemplate restTemplate;

    @Bean
    @ConditionalOnMissingBean(SlackSimpleService.class)
    public SlackSimpleService slackSimpleService() {
        return new SlackSimpleService(getRestTemplateOrCreate());
    }

    @Bean
    @ConditionalOnMissingBean(SlackService.class)
    @ConditionalOnProperty(value = {"slackUrl", "defaultChannel"}, prefix = "slack")
    public SlackService slackService() {
        return new SlackService(
                slackSimpleService(),
                properties.getSlackUrl(),
                properties.getDefaultUsername(),
                properties.getDefaultChannel());
    }

    private RestTemplate getRestTemplateOrCreate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }

}
