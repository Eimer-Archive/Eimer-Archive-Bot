package com.imjustdoom.command.impl;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class SpreadsheetCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"spreadsheet", "ss", "s", "sp", "spreadsheetlink"};
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
                .setTitle("Spreadsheet")
                .setDescription("[Click here for the versions spreadsheet](https://docs.google.com/spreadsheets/u/1/d/e/2PACX-1vQa3D6cn75jIR8T8hEXqrlphdkWI0WBweyqeVnf2wgo8tEvxwxn8ynD4F-oKKaaZQpvT2t1ej6f6ykX/pubhtml)")
                .build()).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}