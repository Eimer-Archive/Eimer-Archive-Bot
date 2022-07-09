package com.imjustdoom.listener;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        User user = event.getUser();
        Guild guild = event.getGuild();

        guild.addRoleToMember(user.getId(), guild.getRoleById("985415668050583573")).queue();
    }
}