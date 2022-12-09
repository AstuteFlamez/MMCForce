package mandomc.mmcforce.handlers;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Board {

    private static Map<UUID, Integer> Tasks = new HashMap<UUID, Integer>();
    private final UUID uuid;


    public Board(UUID uuid) {
        this.uuid = uuid;
    }

    public void setID(int id){
        Tasks.put(uuid, id);
    }

    public int getID(){
        return Tasks.get(uuid);
    }

    public boolean hasID(){
        if(Tasks.containsKey(uuid)){
            return true;
        }
        return false;
    }

    public void stop(){
        Bukkit.getScheduler().cancelTask(Tasks.get(uuid));
        Tasks.remove(uuid);
    }
}
