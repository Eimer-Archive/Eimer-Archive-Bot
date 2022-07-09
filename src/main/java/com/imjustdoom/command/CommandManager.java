package com.imjustdoom.command;

import com.imjustdoom.Main;
import com.imjustdoom.command.impl.*;
import com.imjustdoom.command.impl.admin.ReactionsCmd;
import com.imjustdoom.command.impl.admin.RulesCmd;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private final List<Command> commands = new ArrayList<>();

    public CommandManager() {
        commands.add(new TestCmd());
        commands.add(new ArchiveCmd());
        commands.add(new HelpCmd());
        commands.add(new RulesCmd());
        commands.add(new InfoCmd());
        commands.add(new SpreadsheetCmd());
        commands.add(new ReactionsCmd());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");
        User user = event.getAuthor();

        if (args[0].equalsIgnoreCase("<@985050684380565564>")) {
            new HelpCmd().execute(user, args, event.getMessage(), event.getTextChannel());
            return;
        }

        String strCommand = "";
        for (String prefix : Main.prefix) {
            if (!args[0].toLowerCase().startsWith(prefix.toLowerCase())) continue;
            strCommand = args[0].substring(prefix.length());
        }

        COMMAND:
        for (Command command : commands) {
            for (String name : command.getName()) {
                if (name.equalsIgnoreCase(strCommand)) {
                    if (command.getRoles().length > 0) for (String role : command.getRoles()) {
                        if (!event.getMember().getRoles().contains(event.getGuild().getRoleById(role))) {
                            event.getMessage().reply("You don't have permission to use this command.").queue();
                            continue COMMAND;
                        }
                    }
                    if (command.getUsers().length > 0) for (String user1 : command.getUsers()) {
                        if (!event.getAuthor().getId().equals(user1)) {
                            event.getMessage().reply("You don't have permission to use this command.").queue();
                            continue COMMAND;
                        }
                    }

                    command.execute(user, args, event.getMessage(), event.getTextChannel());
                    return;
                }
            }
        }
    }

    public List<Command> getCommands() {
        return commands;
    }
}
