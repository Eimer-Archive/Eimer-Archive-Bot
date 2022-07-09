package com.imjustdoom.command.impl;

import com.imjustdoom.command.Command;
import net.badbird5907.jdacommand.annotation.Required;
import net.badbird5907.jdacommand.annotation.Sender;
import net.badbird5907.jdacommand.context.CommandContext;
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

    @net.badbird5907.jdacommand.annotation.Command(name = "test", description = "A test command")
    public void test(CommandContext ctx, @Sender User sender, @Required String arg) {
        ctx.reply("Hello, " + sender.getAsTag() + "!" + " " + arg);
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}