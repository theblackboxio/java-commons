package io.theblackbox.commons.integration.slack;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

/**
 * Created by guillermoblascojimenez on 08/11/16.
 */
@Slf4j
@RequiredArgsConstructor
public class SlackSimpleService {

    private final RestTemplate restTemplate;

    public void post(@NonNull String slackUrl, @NonNull String username, @NonNull String channel, @NonNull String message) {

        SlackMessage slackMessage = SlackMessage.builder()
                .username(username)
                .channel(channel)
                .text(message)
                .build();

        post(slackUrl, slackMessage);
    }
    public void post(@NonNull String slackUrl, @NonNull SlackMessage slackMessage) {
        try {
            restTemplate.postForLocation(slackUrl, slackMessage);
        } catch (Exception e) {
            log.error("Exception while posting to Slack", e);
        }
    }
}
