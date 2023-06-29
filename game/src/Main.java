
import Data.build.Build;
import Data.writeData.ReadMap;
import Data.writeData.ReadPlayers;
import Data.writeData.WriteMap;
import javafx.application.Application;
import javafx.stage.Stage;
import view.login;


public class Main extends Application {
    public static void main(String[] args) throws Exception {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        ReadMap readMap=new ReadMap();
        readMap.run();
        readMap.join();
        ReadPlayers writingAllPlayer=new ReadPlayers();
        writingAllPlayer.start();
        writingAllPlayer.join();
        Stage stage1=new login().stage();
        stage1.show();
        ;
    }

}