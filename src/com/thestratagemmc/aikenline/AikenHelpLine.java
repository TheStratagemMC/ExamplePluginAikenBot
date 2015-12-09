package com.thestratagemmc.aikenline;

import com.google.common.eventbus.Subscribe;
import com.thestratagemmc.aikenbot.AikenBot;
import com.thestratagemmc.aikenbot.event.ChatPersonalMessageEvent;
import com.thestratagemmc.aikenbot.plugins.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by axel on 12/2/15.
 */
public class AikenHelpLine extends Plugin {

    List<String> responses = new ArrayList<>();

    public void onEnable(){
        responses.add("Hello from the bot!");
        responses.add("I'm not ready yet. The question is, are you?");
        responses.add("What's up homie!");
        responses.add("I like turtles");
        responses.add("Hello, just call me chester :)");
        responses.add("Literally, just ask me anything in global or local chat!");

        AikenBot.registerListener(this);
    }

    @Override
    public String getName() {
        return "HelpLine-messaging help system for AikenBot.";
    }

    @Override
    public String getAuthor() {
        return "akselm";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }


    @Subscribe
    public void onPersonalMessage(ChatPersonalMessageEvent event){
        event.getMessage().reply(responses.get(
                ThreadLocalRandom.current().nextInt(responses.size())
        ));
    }
}