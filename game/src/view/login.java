package view;

import Data.build.Defence;
import Data.unit.Unit;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.TimerTask;

public class login {
    static Unit unit=new Unit("Knight",1000,20,500,100,20);
    static ImageView imageView;

    public static Stage stage()
    {
        Stage stage=new Stage();
        unit.WalkingLeft();
        imageView=unit.currentPose;
        TranslateTransition t=new TranslateTransition(Duration.millis(5000),imageView);
        TranslateTransition z=new TranslateTransition(Duration.millis(5000),imageView);
        t.setByX(-300);
        t.setByY(100);
        z.setByX(600);
        t.play();

        t.setOnFinished(event -> {
            unit.WalkingRight();
            change();
            unit.WalkingLeft();
            change();
            z.play();
            z.setOnFinished(event1 -> {
                unit.AttackRight();
                change();
            });
        });
        Defence defence=new Defence(8, 8, "cannon", 400, "Defence", 400, 2000, 100);
        ImageView defaultPhoto = defence.defaultPhoto;
        StackPane pane=new StackPane(defaultPhoto);
        pane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(pane,750,750);

        stage.setScene(scene);
        return stage;
    }
    static void  change()
    {
        imageView.setImage(unit.currentPose.getImage());
    }
}

