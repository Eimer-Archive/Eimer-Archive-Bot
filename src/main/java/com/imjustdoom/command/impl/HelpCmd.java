package com.imjustdoom.command.impl;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class HelpCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"help", "h"};
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
                .setTitle("Commands Help")
                .setDescription("Prefix is a! or !")
                .addField("a!archive", "Shows the archive link", false)
                .addField("a!help", "Shows this message", false)
                .addField("a!spreadsheet", "Shows the spreadsheet for software versions", false)
                .addField("a!info", "Shows archive info", false)
                .build()).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}