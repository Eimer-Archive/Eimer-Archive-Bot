package com.imjustdoom.command.impl.admin;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class RulesCmd implements Command {

    @Override
    public String[] getName() {
        return new String[]{"rules", "r"};
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
        channel.sendMessageEmbeds(new EmbedBuilder()
                        .setTitle("Rules:")
                        .setDescription("""
                                **Rule 1**
                                No spamming.
                                **Rule 2**
                                No advertising.
                                **Rule 3**
                                No pinging for no reason
                                **Rule 4**
                                Do not be a jerk.
                                """)
                        .build()).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}