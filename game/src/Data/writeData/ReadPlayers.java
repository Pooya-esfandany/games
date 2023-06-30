package Data.writeData;

import Data.map.Maps;
import Data.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadPlayers extends  Thread{
        @Override
        public void run() {
            try {
                String Url = "jdbc:mysql://localhost/game";
                String name = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(Url, name, "");
                String sqlmsg = "SELECT name,password,win,Battle,Money,MapID,level from player";
                Statement statement = connection.prepareStatement(sqlmsg);
                ResultSet resultSet = statement.executeQuery(sqlmsg);
                while (resultSet.next()) {
                    String username=resultSet.getString("name");
                    String password=resultSet.getString("password");
                    int win=Integer.parseInt(resultSet.getString("win"));
                    int battle=Integer.parseInt(resultSet.getString("battle"));
                    int money=Integer.parseInt(resultSet.getString("money"));
                    int mapId=Integer.parseInt(resultSet.getString("MapID"));
                    int level=Integer.parseInt(resultSet.getString("level"));
                    Player player=new Player(username,password,money,level,battle,win,mapId);
                    player.mapData = Maps.Find(mapId);
                    Player.players.add(player);
                }
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

