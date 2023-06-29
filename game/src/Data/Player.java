package Data;

import Data.map.MapData;
import Data.map.Maps;
import Data.writeData.WritePlayer;

import java.util.ArrayList;

public class Player {
    public static ArrayList<Player> players=new ArrayList<>();
    public String name;
    public String password;
    public int win;
    public int totalMatch;
    public int level;
    int capacity;
    public int currentMoney;
    public int mapID;
    public  MapData mapData;
    private Player(String name,String password)
    {
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
            player.mapData =new MapData();
            Maps.mapData.add(player.mapData);
            player.mapID= player.mapData.mapID;
            WritePlayer writePlayer=new WritePlayer(player);
            writePlayer.start();
            try{
            writePlayer.join();
        }catch (Exception e)
            {
                e.printStackTrace();
            }}
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
