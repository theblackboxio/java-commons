package io.theblackbox.commons.integration.slack.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by guillermoblascojimenez on 08/11/16.
 */

@ConfigurationProperties("slack")
public class SlackProperties {

    private String slackUrl;
    private String defaultUsername = "slack-tbb-bot";
    private String defaultChannel;

    public String getSlackUrl() {
        return slackUrl;
    }

    public void setSlackUrl(String slackUrl) {
        this.slackUrl = slackUrl;
    }

    public String getDefaultUsername() {
        return defaultUsername;
    }

    public void setDefaultUsername(String defaultUsername) {
        this.defaultUsername = defaultUsername;
    }

    public String getDefaultChannel() {
        return defaultChannel;
    }

    public void setDefaultChannel(String defaultChannel) {
        this.defaultChannel = defaultChannel;
    }
}
