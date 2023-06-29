package Data.writeData;

import Data.Player;

import java.sql.Connection;
import java.sql.DriverManager;

public class WritePlayer extends Thread {
    Player player;
    public WritePlayer(Player player){
        this.player=player;
    }
    @Override
    public void run()
    {
        try{
        String Url = "jdbc:mysql://localhost/game";
        String name = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(Url, name, "");
        int win=player.win;
        int battle=player.totalMatch;
        int money=player.currentMoney;
        int level=player.level;
        int mapId=player.mapID;
        String add =String.format("INSERT INTO player (name,Password,win,Battle,money,MapID,level) VALUES ('%s','%s',%d,%d,%d,%d,%d)",player.name,
                player.password,win,battle,money,mapId,level);


        connection.prepareStatement(add).execute();
        connection.close();
    }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
