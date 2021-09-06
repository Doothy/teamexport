package gg.oddysian.death.teamexport.utils;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import gg.oddysian.death.teamexport.Teamexport;

public class PokemonDataUtils {

    public static String getStat (Pokemon pkmn, String stat){
        switch (stat){
            case "name": return pkmn.getSpecies().name;
            case "gender": return pkmn.getGender().toString();
            case "item": return pkmn.getHeldItem().getDisplayName();
            case "ability": return pkmn.getAbility().getName();
            case "shiny": if (pkmn.isShiny()) return "yes"; else return null;
            case "evs_HP": return "" + pkmn.getEVs().getStat(StatsType.HP);
            case "evs_ATK": return "" + pkmn.getEVs().getStat(StatsType.Attack);
            case "evs_DEF": return "" + pkmn.getEVs().getStat(StatsType.Defence);
            case "evs_SPA": return "" + pkmn.getEVs().getStat(StatsType.SpecialAttack);
            case "evs_SPD": return "" + pkmn.getEVs().getStat(StatsType.SpecialDefence);
            case "evs_SPE": return "" + pkmn.getEVs().getStat(StatsType.Speed);
            case "nature": return pkmn.getNature().toString();
            case "ivs_HP": return "" + pkmn.getIVs().getStat(StatsType.HP);
            case "ivs_ATK": return "" + pkmn.getIVs().getStat(StatsType.Attack);
            case "ivs_DEF": return "" + pkmn.getIVs().getStat(StatsType.Defence);
            case "ivs_SPA": return "" + pkmn.getIVs().getStat(StatsType.SpecialAttack);
            case "ivs_SPD": return "" + pkmn.getIVs().getStat(StatsType.SpecialDefence);
            case "ivs_SPE": return "" + pkmn.getIVs().getStat(StatsType.Speed);
            case "move1": if(pkmn.getMoveset().attacks[0] != null) return pkmn.getMoveset().attacks[0].getMove().getAttackName(); else return null;
            case "move2": if(pkmn.getMoveset().attacks[1] != null) return pkmn.getMoveset().attacks[1].getMove().getAttackName(); else return null;
            case "move3": if(pkmn.getMoveset().attacks[2] != null) return pkmn.getMoveset().attacks[2].getMove().getAttackName(); else return null;
            case "move4": if(pkmn.getMoveset().attacks[3] != null) return pkmn.getMoveset().attacks[3].getMove().getAttackName(); else return null;
            default: return null;
        }
    }

    public static String[] allStats(Pokemon pkmn){
        String[] allStatsAsString = new String[22];
        allStatsAsString[0] = getStat(pkmn, "name");
        allStatsAsString[1] = getStat(pkmn, "gender");
        allStatsAsString[2] = getStat(pkmn, "item");
        allStatsAsString[3] = getStat(pkmn, "ability");
        allStatsAsString[4] = getStat(pkmn, "shiny");
        allStatsAsString[5] = getStat(pkmn, "evs_HP");
        allStatsAsString[6] = getStat(pkmn, "evs_ATK");
        allStatsAsString[7] = getStat(pkmn, "evs_DEF");
        allStatsAsString[8] = getStat(pkmn, "evs_SPA");
        allStatsAsString[9] = getStat(pkmn, "evs_SPD");
        allStatsAsString[10] = getStat(pkmn, "evs_SPE");
        allStatsAsString[11] = getStat(pkmn, "nature");
        allStatsAsString[12] = getStat(pkmn, "ivs_HP");
        allStatsAsString[13] = getStat(pkmn, "ivs_DEF");
        allStatsAsString[14] = getStat(pkmn, "ivs_ATK");
        allStatsAsString[15] = getStat(pkmn, "ivs_SPA");
        allStatsAsString[16] = getStat(pkmn, "ivs_SPD");
        allStatsAsString[17] = getStat(pkmn, "ivs_SPE");
        allStatsAsString[18] = getStat(pkmn, "move1");
        allStatsAsString[19] = getStat(pkmn, "move2");
        allStatsAsString[20] = getStat(pkmn, "move3");
        allStatsAsString[21] = getStat(pkmn, "move4");

        return allStatsAsString;
    }

    public static String PokemonToFormattedString(String[]stats){
        if (stats.length != 22)
            return null;
        else {
            //General
            String formattedString = "";
            formattedString = formattedString + stats[0];
            if(stats[1].equals("Male")) {
                formattedString = formattedString + " (M) ";
            }
            if(stats[1].equals("Female")) {
                formattedString = formattedString + " (F) ";
            }
            if(stats[1].equals("None")) {
                formattedString = formattedString + " ";
            }
            if(!stats[2].equals("Air")) {
                formattedString = formattedString + "@ " + stats[2] + "\n";
            }
            formattedString = formattedString  + "\n";
            formattedString = formattedString + "Ability: " + stats[3] + "\n";
            if (stats[4] != null){
                if(stats[4].equals("yes"))
                    formattedString = formattedString + "Shiny: Yes" + "\n";
            }
            //EVs
            formattedString = formattedString + "EVs: ";
            if(!stats[5].equals("0"))
                formattedString = formattedString + stats[5] + " HP / ";
            if(!stats[6].equals("0"))
                formattedString = formattedString + stats[6] + " Atk / ";
            if(!stats[7].equals("0"))
                formattedString = formattedString + stats[7] + " Def / ";
            if(!stats[8].equals("0"))
                formattedString = formattedString + stats[8] + " SpA / ";
            if(!stats[9].equals("0"))
                formattedString = formattedString + stats[9] + " SpD / ";
            if(!stats[10].equals("0"))
                formattedString = formattedString + stats[10] + " Spe";
            formattedString = formattedString + "\n";
            formattedString = formattedString + stats[11] + " Nature" + "\n";
            //IVs
            formattedString = formattedString + "IVs: " + stats[12] + " HP / " + stats[13] + " Atk / "
            + stats[14] + " Def / " + stats[15] + " SpA / " + stats[16] + " SpD / " + stats[17] + " Spe" + "\n";
            //Moves
            if(stats[18]!= null) {
                formattedString = formattedString + "- " + stats[18] + "\n";
            }
            if(stats[19]!= null) {
                formattedString = formattedString + "- " + stats[19] + "\n";
            }
            if(stats[20]!= null) {
                formattedString = formattedString + "- " + stats[20] + "\n";
            }
            if(stats[21]!= null) {
                formattedString = formattedString + "- " + stats[21] + "\n";
            }
            return formattedString;
        }
    }

}
