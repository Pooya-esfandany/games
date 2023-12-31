
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
        login.stage().show();

    }


}