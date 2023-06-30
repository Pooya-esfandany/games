package view.mapView;

import Data.Player;
import Gate.Check;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Buytower {
    public static Stage stage(Player player)
    {
        Stage stage=new Stage();
        ImageView cannon=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\cannon.png");
        ImageView camp=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\camp.png");
        ImageView crusher=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\crusher.png");
        ImageView gold=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\gold storage.png");
        HBox box=new HBox();
        cannon.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            try
            {
                Check.money(player,5000);
                AddTower.stage(player,10).show();
                stage.close();
            }
            catch (Exception e)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle(e.getMessage());
                alert.setHeaderText(e.toString());
                alert.showAndWait();
                MainPage.stage(player).show();
                stage.close();
            }
        });
        camp.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            try
            {
                Check.money(player,5000);
                AddTower.stage(player,20).show();
                stage.close();
            }
            catch (Exception e)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle(e.getMessage());
                alert.setHeaderText(e.toString());
                alert.showAndWait();
                MainPage.stage(player).show();
                stage.close();
            }
        });
        crusher.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            try
            {
                Check.money(player,5000);
                AddTower.stage(player,40).show();
                stage.close();
            }
            catch (Exception e)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle(e.getMessage());
                alert.setHeaderText(e.toString());
                alert.showAndWait();
                MainPage.stage(player).show();
                stage.close();
            }
        });
        gold.setOnMouseClicked(event -> {
            AudioClip click=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            click.play(20);
            try
            {
                Check.money(player,5000);
                AddTower.stage(player,30).show();
                stage.close();
            }
            catch (Exception e)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle(e.getMessage());
                alert.setHeaderText(e.toString());
                alert.showAndWait();
                MainPage.stage(player).show();
                stage.close();
            }
        });

        box.getChildren().addAll(gold,crusher,camp,cannon);
        Scene scene=new Scene(box);
        stage.setScene(scene);
        return stage;
    }
}
