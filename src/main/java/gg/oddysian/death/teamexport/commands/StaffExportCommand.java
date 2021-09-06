package gg.oddysian.death.teamexport.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class StaffExportCommand extends CommandBase {

    @Override
    public String getName(){
        return "getexport";
    }

    @Override
    public String getUsage(ICommandSender sender){
        return "/getexport username";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args){

    }

}
