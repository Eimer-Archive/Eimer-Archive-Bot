package com.imjustdoom.command.impl.admin;

import com.imjustdoom.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

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

        String messageText = """
                                **REACT TO OPT OUT**
                                :pushpin: - Receive announcement notifications.
                                
                                **REACT TO OPT IN**
                                :bell: - Receive Minecraft server notifications.
                                """;

        if(args.length >= 4 && args[1].equalsIgnoreCase("edit")) {
            MessageAction embed = message.getGuild().getChannelById(MessageChannel.class, args[2]).editMessageEmbedsById(args[3], new EmbedBuilder()
                    .setTitle("Roles:")
                    .setDescription(messageText)
                    .build());


            embed.flatMap(message1 -> {
                message1.addReaction("📌").queue();
                message1.addReaction("🔔").queue();
                return null; // TODO: fix error https://pastebin.com/xpcWYnyY
            }).queue();
            return;
        }
        MessageEmbed embed = new EmbedBuilder()
                .setTitle("Roles:")
                .setDescription(messageText)
                .build();
        channel.sendMessageEmbeds(embed).flatMap(message1 -> {
            message1.addReaction("📌").queue();
            message1.addReaction("🔔").queue();
            return null;
        }).queue();
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}