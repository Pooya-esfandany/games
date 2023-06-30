package view.mapView;

import Data.Player;
import Data.build.Builds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddTower {
    public static Stage stage(Player player, int number)
    {
        ArrayList<ImageView> views=new ArrayList<>();
        Stage stage=new Stage();
        Pane pane=new Pane();
        BackgroundImage backgroundImage=new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\ground.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++)
            {
                if(player.mapData.safeZone[i][j]!=-1)
                {
                    views.add((Builds.getByID(player.mapData.safeZone[i][j]).defaultPhoto));
                    views.get(views.size()-1).setLayoutY(j*100);
                    views.get(views.size()-1).setLayoutX(i*100);
                }
            }}
        pane.getChildren().addAll(views);
        Scene scene=new Scene(pane,700,700);
        scene.setOnMouseClicked(event -> {
            int clickedX= (int) event.getX();
            int clickedY=(int)event.getY();
            int x=(int)Math.floor(clickedX/100);
            int y=(int)Math.floor(clickedY/100);
            player.mapData.Add(x,y,number);
            MainPage.stage(player).show();
            stage.close();
        });
        stage.setScene(scene);
        return stage;
    }
}
