package com.imjustdoom.command.impl;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class InfoCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"info", "i"};
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String[] getRoles() {
        return new String[]{};
    }

    @Override
    public String[] getUsers() {
        return new String[]{};
    }

    @Override
    public void execute(User user, String[] args, Message message, TextChannel channel) {
        message.replyEmbeds(new EmbedBuilder()
                .setTitle("Statistics")
                .addField("Total builds", "517", false)
                .addField("CraftBukkit Builds", "514", false)
                .addField("Spigot/CraftBukkit-- Builds", "1", false)
                .addField("DytanicSpigot Builds", "1", false)
                .addField("GSpigot Builds", "1", false)
                .build()).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}