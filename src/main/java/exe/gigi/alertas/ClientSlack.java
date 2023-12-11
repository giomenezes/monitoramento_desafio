package exe.gigi.alertas;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.api.ApiTestResponse;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Message;

import java.io.IOException;

public class ClientSlack {
    public static void main(String[] args) throws SlackApiException, IOException {
        Slack slack = Slack.getInstance();
        String token = System.getenv("xoxb-5792399293281-6317924512885-miczgWEJGfuFvHqBzJ1QsXxy");

        ChatPostMessageResponse response = slack.methods(token).chatPostMessage(req -> req
                .channel("#geral")
                .text("Write one, post anywhere"));
        if (response.isOk()) {
            Message postedMessage = response.getMessage();
            System.out.println(postedMessage);
        } else {
            String errorCode = response.getError(); // e.g., "invalid_auth", "channel_not_found"
            System.out.println(errorCode);
        }
    }
}
