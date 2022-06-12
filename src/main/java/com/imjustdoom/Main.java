package com.imjustdoom;

import com.google.gson.Gson;
import com.imjustdoom.command.CommandManager;
import com.imjustdoom.config.Config;
import com.imjustdoom.listener.JoinListener;
import com.imjustdoom.listener.ReactionListener;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static final String[] prefix = new String[]{"!", "A!"};

    public static CommandManager commandManager = new CommandManager();
    public static JDA jda;

    public static Config config;

    public static void main(String[] args) throws LoginException, IOException {

        String data = Files.readString(Path.of("config.json"));
        config = new Gson().fromJson(data, Config.class);

        JDABuilder builder = JDABuilder.createDefault(config.token)
                .addEventListeners(commandManager, new EventWaiter(), new JoinListener(), new ReactionListener())
                .enableIntents(GatewayIntent.GUILD_MEMBERS);

        jda = builder.build();

        jda.getPresence().setActivity(Activity.playing("Archiving server software"));


    }
}
