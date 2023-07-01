package view.mapView;

import Data.Player;
import Data.build.Build;
import Data.build.Builds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Upgrade {
    public static Stage stage(Player player,int x,int y,int buildID)
    {
        Stage stage=new Stage();
        Build build=Builds.getByID(buildID);
        Pane pane=new Pane();
        int level=buildID%10;
        Text text=new Text("do you want to upgrate it to"+(level+2));
        ImageView upgrade=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\upgrade.png");
        text.setLayoutX(250);
        text.setLayoutY(30);
        StackPane stackPane=new StackPane();
        stackPane.getChildren().add(upgrade);
        Text cost=new Text(Integer.toString(build.cost));
        cost.setScaleX(3);
        cost.setScaleY(3);

        stackPane.getChildren().add(cost);
        stackPane.setLayoutX(220);
        stackPane.setLayoutY(350);
        Scene scene=new Scene(pane,643,471);
        Image backgroundimg=new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\page\\upgrade.png");
        BackgroundImage backgroundImage=new BackgroundImage(backgroundimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        pane.getChildren().add(stackPane);
        pane.getChildren().add(text);
        scene.setOnMouseClicked(event -> {
            System.out.println(event.getX());
            System.out.println(event.getY());
        });
        stage.setScene(scene);
        return stage;
    }

}
