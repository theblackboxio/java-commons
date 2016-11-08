package io.theblackbox.commons.integration.slack;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by guillermoblascojimenez on 08/11/16.
 */
@RequiredArgsConstructor
public class SlackService {

    private final SlackSimpleService slackSimpleService;
    private final String slackUrl;
    private final String defaultUsername;
    private final String defaultChannel;

    public void post(@NonNull String username, @NonNull String channel, @NonNull String message) {
        slackSimpleService.post(slackUrl, username, channel, message);
    }

    public void postToDefaultChannel(@NonNull String username, @NonNull String message) {
        post(username, defaultChannel, message);
    }

    public void post(@NonNull String message) {
        post(defaultUsername, defaultChannel, message);
    }

}
