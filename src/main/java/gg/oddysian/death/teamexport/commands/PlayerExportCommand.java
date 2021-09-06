package gg.oddysian.death.teamexport.commands;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import gg.oddysian.death.teamexport.Teamexport;
import gg.oddysian.death.teamexport.utils.PermissionUtils;
import gg.oddysian.death.teamexport.utils.PartyUtils;
import gg.oddysian.death.teamexport.utils.PokemonDataUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import java.util.UUID;


public class PlayerExportCommand extends CommandBase {

    @Override
    public String getName(){
        return "teamexport";
    }

    @Override
    public String getUsage(ICommandSender sender){
        return "/teamexport";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args){
        if(sender instanceof EntityPlayerMP){
            EntityPlayerMP player = (EntityPlayerMP) sender;
            if(PermissionUtils.canUse("teamexport.command.teamexport", sender)){
                UUID uuid = player.getUniqueID();
                Pokemon[] party = PartyUtils.getParty(uuid);
                if (args.length != 1){
                    player.sendMessage(new TextComponentString("\u00A7c" + "Please provide only one argument! (all; <Slot>)"));
                }
                else if (args[0].equals("all")) {
                    StringBuilder out = new StringBuilder();
                    for (Pokemon pokemon : party) {
                        if(pokemon != null) {
                            out.append(PokemonDataUtils.PokemonToFormattedString(PokemonDataUtils.allStats(pokemon)));
                            out.append("\n");
                        }
                    }
                    Teamexport.log.info(out);
                }
                else if (args[0].equals("1") || args[0].equals("2") || args[0].equals("3")|| args[0].equals("4") || args[0].equals("5") || args[0].equals("6")){
                    StringBuilder out = new StringBuilder();
                    int i = 0;
                    if(args[0].equals("2")) i = 1;
                    if(args[0].equals("3")) i = 2;
                    if(args[0].equals("4")) i = 3;
                    if(args[0].equals("5")) i = 4;
                    if(args[0].equals("6")) i = 5;
                    if (i <= party.length) {
                        if(party[i] != null) {
                            out.append(PokemonDataUtils.PokemonToFormattedString(PokemonDataUtils.allStats(party[i])));
                            Teamexport.log.info(out);
                        }
                        else{
                            player.sendMessage(new TextComponentString("\u00A7c" + "This slot is empty :kekWait:"));
                        }
                    }
                }
                else {player.sendMessage(new TextComponentString("\u00A7c" + "Please provide a valid argument! (all, <Slot>)"));}
            }
        }
    }

}
