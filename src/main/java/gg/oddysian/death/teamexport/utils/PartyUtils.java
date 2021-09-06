package gg.oddysian.death.teamexport.utils;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import java.util.UUID;

public class PartyUtils {

    //I intend on expanding this util in the future, depending on when I need to do more party related stuff
    public static Pokemon[] getParty(UUID uuid){
        PlayerPartyStorage playerPartyStorage = Pixelmon.storageManager.getParty(uuid);
        return playerPartyStorage.getAll();
    }

}
