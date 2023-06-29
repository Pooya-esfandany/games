package view.mapView;

import Data.Player;
import Data.build.Build;
import Data.build.Builds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainPage {

    public static Stage stage(Player player)
    {Stage stage=new Stage();
        ArrayList<ImageView> views=new ArrayList<>();
        Pane pane=new Pane();
        BackgroundImage backgroundImage=new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\ground.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        for(int i=0;i<15;i++){
        for(int j=0;j<15;j++)
        {
            if(player.mapData.safeZone[i][j]!=-1)
            {
                views.add((Builds.getByID(player.mapData.safeZone[i][j]).defaultPhoto));
                views.get(views.size()-1).setLayoutY(j*50);
                views.get(views.size()-1).setLayoutX(i*50);

            }
        }}
        pane.getChildren().addAll(views);
        Scene scene=new Scene(pane,750,750);
        stage.setScene(scene);
        return stage;
    }

}
