package com.imjustdoom.command.impl;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class TestCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"test", "t"};
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
        message.reply("Test command executed.").queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}