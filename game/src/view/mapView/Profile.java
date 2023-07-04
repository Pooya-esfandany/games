package view.mapView;

import Data.Player;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Profile {
    public static Stage stage(Player player)
    {
        Stage stage=new Stage();
        Pane pane=new Pane();
        BackgroundImage backgroundImage=new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\page\\profile.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        Scene scene=new Scene(pane,1280,418);
        scene.setOnMouseClicked(event -> {
            System.out.println(event.getX()+"X");
            System.out.println(event.getY()+"Y");
        });
        ImageView imageView=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\level.png");
        StackPane stackPane=new StackPane(imageView);
        Text levelText=new Text(Integer.toString(player.level));
        stackPane.getChildren().add(levelText);
        stackPane.setLayoutX(40);
        stackPane.setLayoutY(125);

        Text name=new Text(player.name);
        name.setLayoutX(200);
        name.setLayoutY(150);
        name.setScaleY(2);
        name.setScaleX(3);
        Text totalMath=new Text(Integer.toString(player.totalMatch));
        totalMath.setLayoutX(266);
        totalMath.setLayoutY(388);
        Text win=new Text(Integer.toString(player.win)) ;
        win.setLayoutY(389);
        win.setLayoutX(890);
        name.setTextAlignment(TextAlignment.LEFT);
        name.setStyle("-fx-background-color: 1,1,1");
        pane.getChildren().addAll(stackPane,name,totalMath,win);
        stage.setResizable(false);
        scene.setOnMouseClicked(event ->
        {
            stage.close();
            MainPage.stage(player).show();
        });
        stage.setScene(scene);
        return stage;
    }
}
