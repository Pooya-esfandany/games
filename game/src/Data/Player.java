package Data;

import Data.map.MapData;
import Data.map.Maps;

import java.util.ArrayList;

public class Player {
    public static ArrayList<Player> players=new ArrayList<>();
    String name;
    String password;
    int win;
    int totalMatch;
    int level;
    int capacity;
    int currentMoney;
    public int mapID;
    public MapData mapData;
    private Player(String name,String password)
    {
            mapData =new MapData();
            Maps.mapData.add(mapData);
            this.mapID= mapData.mapID;
            this.name=name;
            this.password=password;
    }
    public Player(String name,String password,int currentMoney,int level,int totalMatch,int win,int mapID)
    {
        this.name=name;
        this.password=password;
        this.currentMoney=currentMoney;
        this.mapID=mapID;
        this.level=level;
        this.totalMatch=totalMatch;
        this.mapID=mapID;
    }
    public static  boolean addPlayer(String name,String password)
    {
        boolean isValid=true;
        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).name.equals(name))
            {
                isValid=false;
            }
        }
        if(isValid=true)
        {
            Player player=new Player(name, password);
            players.add(player);
        }
        return isValid;
    }
    public static Player get(String name,String password)
    {
        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).name.equals(name))
            {
                if(players.get(i).password.equals(password))
                    return players.get(i);
            }
        }
        return null;
    }
}
