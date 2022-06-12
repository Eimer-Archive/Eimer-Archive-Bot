package com.imjustdoom.command.impl;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class ArchiveCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"archive", "a", "archivelink"};
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
                .setTitle("Archive link")
                .setDescription("[Click here for the archive website link](https://archive.anythingmc.xyz)")
                .build()).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}