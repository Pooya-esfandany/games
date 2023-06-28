
import Data.Maps;
import Data.Player;
import Data.writeData.ReadMap;
import Data.writeData.WriteMap;
import Data.writeData.WritePlayer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import view.login;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {
    public static void main(String[] args) throws Exception {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        WritePlayer writingAllPlayer=new WritePlayer();
        writingAllPlayer.start();
        writingAllPlayer.join();
        ReadMap readMap=new ReadMap();
        readMap.start();;
        readMap.join();

        
        Player.addPlayer("pooya","esf");
        System.out.println(Maps.maps.size());

        Stage stage1=new login().stage();
        stage1.show();
        ;
    }

}