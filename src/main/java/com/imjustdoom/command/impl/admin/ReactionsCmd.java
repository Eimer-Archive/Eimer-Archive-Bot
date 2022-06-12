package com.imjustdoom.command.impl.admin;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class ReactionsCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"reactions", "reaction", "reactionlink"};
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
        return new String[]{"474482013886480385"};
    }

    @Override
    public void execute(User user, String[] args, Message message, TextChannel channel) {
        MessageEmbed embed = new EmbedBuilder()
                .setTitle("Roles:")
                .setDescription("""
                                **REACT TO REMOVE THE ROLE**
                                :pushpin: - Receive announcement notifications.
                                """)
                .build();
        channel.sendMessageEmbeds(embed).flatMap(message1 -> message1.addReaction("📌")).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}