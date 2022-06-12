package com.imjustdoom.listener;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {

    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        Guild guild = event.getGuild();

        if(!event.getMessageId().equals("985447032544170034")) return;

        if(event.getReaction().getReactionEmote().getName().equals("📌")) {
            guild.removeRoleFromMember(UserSnowflake.fromId(event.getUserId()), guild.getRoleById("985415668050583573")).queue();
        }
    }

    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        Guild guild = event.getGuild();

        if(!event.getMessageId().equals("985447032544170034")) return;

        if(event.getReaction().getReactionEmote().getName().equals("📌")) {
            guild.addRoleToMember(UserSnowflake.fromId(event.getUserId()), guild.getRoleById("985415668050583573")).queue();
        }
    }
}