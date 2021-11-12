package me.cosmic.jda;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

public class Bot extends ListenerAdapter {

    public static void main(String args[]) throws LoginException {

        JDA jda = JDABuilder.createDefault("" /* -- Replace this with a bot token -- */)
                .addEventListeners(new Bot())
                .build();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Only accept commands from guilds
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (event.getAuthor().isBot()) {
            if (event.getMessage().isWebhookMessage()) {
                if (event.getChannel().getId().equals("900470016552624168" /* -- Needs to be changed to #drive-additions channel ID -- */)) {
                    event.getChannel().sendMessage("<@&906686308330643486>" /* -- Needs to be changed to the Upload Alerts role ID -- */).queue();
                } else {
                    if (!(event.getMessage().getEmbeds().isEmpty())) {
                        if (event.getChannel().getId().equals("906692533751513131" /* -- Needs to be changed to #aes-keys channel ID -- */)) {
                            event.getChannel().sendMessage("<@&906694263851585588>" /* -- Needs to be changed to AES Alert role ID -- */).queue();
                        }
                    }
                }
            } else {
                return;
            }
        }

        /* --- Code for if we wanted to stop people from posting messages that don't contain an image ---
        if (event.getGuild().getId().equalsIgnoreCase("786576510432706561")) {
            if (event.getMessage().getChannel().getId().equals("786576510890803261")) {
                List<Message.Attachment> attachments = message.getAttachments();
                if (message.getAttachments().isEmpty()) {
                    message.delete().queue();
                    User p = event.getAuthor();
                    p.openPrivateChannel().flatMap(channel -> channel.sendMessage("Please attach an image/gif to your message and resend it!")).queue();
                    System.out.println("Received a message!");
                }
            }
        }*/
    }
}
