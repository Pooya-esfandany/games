
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

        Stage stage1= login.stage();
        stage1.show();
        ;
    }

}