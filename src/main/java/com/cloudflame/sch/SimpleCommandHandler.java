package com.cloudflame.sch;

import cn.nukkit.command.*;
import cn.nukkit.plugin.PluginBase;
import com.cloudflame.sch.template.HandlerInstance;

import java.util.function.BiFunction;

public class SimpleCommandHandler extends PluginBase {

    private static SimpleCommandHandler instance;

    @Override
    public void onEnable() {
        instance = this;


        SimpleCommandHandler.getInstance().setPluginCommandHandler(this, "abc", (sender, args) -> {
            getLogger().error("PLUGIN OK");
            return false;
        });

        SimpleCommandHandler.getInstance().registerNewCommand("test", (sender, args) -> {
            getLogger().error("OK");
            return false;
        });
    }

    public void setPluginCommandHandler(PluginBase plugin, String command, HandlerInstance<CommandSender, String[], Boolean> handler) {
        PluginIdentifiableCommand pluginCommand = plugin.getCommand(command);
        if(pluginCommand instanceof PluginCommand) {
            ((PluginCommand) pluginCommand).setExecutor((commandSender, command1, s, strings) -> handler.apply(commandSender, strings));
        }
    }

    public void registerNewCommand(String command, HandlerInstance<CommandSender, String[], Boolean> handler, String ...permission) {
        Command cmd = new Command(command) {
            @Override
            public boolean execute(CommandSender commandSender, String s, String[] strings) {
                return handler.apply(commandSender, strings);
            }
        };
        if(permission.length == 1) cmd.setPermission(permission[0]);

        getServer().getCommandMap().register("handler_registered", cmd);
    }

    public void registerNewCommand(String command, String descr, HandlerInstance<CommandSender, String[], Boolean> handler, String ...permission) {
        Command cmd = new Command(command, descr) {
            @Override
            public boolean execute(CommandSender commandSender, String s, String[] strings) {
                return handler.apply(commandSender, strings);
            }
        };
        if(permission.length == 1) cmd.setPermission(permission[0]);

        getServer().getCommandMap().register("handler_registered", cmd);
    }

    public void registerNewCommand(String command, String descr, String usage, HandlerInstance<CommandSender, String[], Boolean> handler, String ...permission) {
        Command cmd = new Command(command, descr, usage) {
            @Override
            public boolean execute(CommandSender commandSender, String s, String[] strings) {
                return handler.apply(commandSender, strings);
            }
        };
        if(permission.length == 1) cmd.setPermission(permission[0]);

        getServer().getCommandMap().register("handler_registered", cmd);
    }

    public void registerNewCommand(String command, String descr, String usage, String[] aliases, HandlerInstance<CommandSender, String[], Boolean> handler, String ...permission) {
        Command cmd = new Command(command, descr, usage, aliases) {
            @Override
            public boolean execute(CommandSender commandSender, String s, String[] strings) {
                return handler.apply(commandSender, strings);
            }
        };
        if(permission.length == 1) cmd.setPermission(permission[0]);

        getServer().getCommandMap().register("handler_registered", cmd);
    }

    public static SimpleCommandHandler getInstance() {
        return instance;
    }
}
