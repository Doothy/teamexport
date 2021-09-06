package gg.oddysian.death.teamexport;

import gg.oddysian.death.teamexport.commands.PlayerExportCommand;
import gg.oddysian.death.teamexport.commands.StaffExportCommand;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(
        modid = Teamexport.MOD_ID,
        name = Teamexport.MOD_NAME,
        version = Teamexport.VERSION,
        acceptableRemoteVersions = "*",
        serverSideOnly = true
)
public class Teamexport {

    public static final String MOD_ID = "teamexport";
    public static final String MOD_NAME = "Teamexport";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static Logger log = LogManager.getLogger(MOD_NAME);

    @Mod.Instance(MOD_ID)
    public static Teamexport INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event){
        log.info("Death's teamexport command has joined the battlefield to export all the teams!");
    }
    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new PlayerExportCommand());
        event.registerServerCommand(new StaffExportCommand());
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
