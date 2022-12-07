package mandomc.mmcforce.handlers;

import mandomc.mmcforce.configs.CooldownConfig;
import org.bukkit.entity.Player;

public class ConvertFromSecs {

    public static String convertFromSecs(Player player){

        int n = CooldownConfig.get().getInt(player.getUniqueId().toString());

        int week = n / 7*(24*3600);

        n = n % 7*(24*3600);
        int day = n / (24 * 3600);

        n = n % (24*3600);
        int hour = n /3600;

        n %= 3600;
        int minutes = n / 60;

        n %= 60;
        int seconds = n;

        return week + " " + "weeks " + day + " " + "days " + hour + " " + "hour " + minutes + " " + "minutes " + seconds + " " + "seconds ";
    }
}
