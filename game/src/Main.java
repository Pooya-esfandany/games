
import Data.Player;
import Data.map.MapData;
import Data.map.Maps;
import Data.writeData.ReadMap;
import Data.writeData.ReadPlayers;
import javafx.application.Application;
import javafx.stage.Stage;
import view.mainPage.login;


public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ReadMap readMap = new ReadMap();
        readMap.start();
        readMap.join();

        ReadPlayers writingAllPlayer = new ReadPlayers();
        writingAllPlayer.start();
        writingAllPlayer.join();
        for (int i = 0; i < Player.players.size(); i++) {
            MapData.added();
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d  ", Player.players.get(0).mapData.safeZone[j][i]);
            }
            System.out.println(" ");
        }

        Stage stage1 = new login().stage();
        stage1.show();
        ;
    }

}