package view.mapView;

import Data.Player;
import Data.build.Build;
import Data.build.Builds;
import Data.build.Storage;
import Data.map.MapData;
import Data.map.Maps;
import Data.writeData.UpgradePlayer;
import Data.writeData.WriteMap;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.attack.Resource;

import java.util.ArrayList;

public class MainPage {

    public static Stage stage(Player player)
    {Stage stage=new Stage();

        int levelNumber=player.mapData.levelCalculator()-4;
        player.level=levelNumber;
        AudioClip media=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/map/main.mp3");
        media.play(50);
        ArrayList<ImageView> views=new ArrayList<>();
        Pane pane=new Pane();
        Image level=new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\level.png");
        ImageView shop=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\shop.png");
        ImageView save=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\save.png");
        ImageView attack=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\attack.png");
        attack.setLayoutY(600);
        attack.setLayoutX(0);
        save.setOnMouseClicked(event -> {
            WriteMap writeMap=new WriteMap();
            UpgradePlayer upgradePlayer=new UpgradePlayer(player);
            writeMap.start();
            upgradePlayer.start();
            try {
                writeMap.join();
                upgradePlayer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        save.setLayoutY(550);
        save.setLayoutX(650);
        shop.setLayoutX(600);
        shop.setLayoutY(600);
        StackPane stackPane=new StackPane(new ImageView(level));
        shop.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            Buytower.stage(player).show();
            stage.close();
            media.stop();
        });
        stackPane.setAlignment(Pos.CENTER);
        Text text=new Text(Integer.toString(levelNumber));
        stackPane.getChildren().addAll(text);
        stackPane.setLayoutY(0);
        stackPane.setLayoutX(0);
        stackPane.setOnMouseClicked(event -> {
            media.stop();
            stage.close();
            Profile.stage(player).show();
        });
        BackgroundImage backgroundImage=new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\ground.png"),
                BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
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
        Text money=new Text(player.currentMoney+"$");
        pane.getChildren().add(money);
        money.setLayoutY(30);
        money.setLayoutX(600);
        money.setScaleX(3);
        money.setScaleY(2);
        attack.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            Resource.stage(player).show();
            stage.close();
            media.stop();
        });

        pane.getChildren().addAll(views);
        pane.getChildren().add(stackPane);
        pane.getChildren().add(shop);
        pane.getChildren().add(save);
        pane.getChildren().add(attack);
        Scene scene=new Scene(pane,700,700);

        stage.setScene(scene);
        stage.setResizable(false);
        scene.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            int clickedX= (int) event.getX();
            int clickedY=(int)event.getY();
            int x=(int)Math.floor(clickedX/100);
            int y=(int)Math.floor(clickedY/100);
            int id=(player.mapData.get(x,y));
            if(id!=-1)
            {
                media.stop();
                 Upgrade.stage(player,x,y,id).show();
                stage.close();
            }


        });

        ;
        return stage;
    }

}
