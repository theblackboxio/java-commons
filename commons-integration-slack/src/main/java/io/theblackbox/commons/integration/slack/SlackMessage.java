package io.theblackbox.commons.integration.slack;

import lombok.Builder;
import lombok.Value;

/**
 * Created by guillermoblascojimenez on 11/07/16.
 */
@Value
@Builder
class SlackMessage {

    private final String username;
    private final String channel;
    private final String text;

}
