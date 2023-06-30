package view.mainPage;

import Data.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import view.mainPage.login;
import view.mapView.MainPage;

public class Sign_in {
    public static Stage stage()
    {
        Stage stage=new Stage();
        TextField F_name=new TextField("enter your name");
        TextField F_password=new TextField("enter your password");
        ImageView haveAccount=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\page\\have.png");
        ImageView exit=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\exit.png");
        ImageView confirm=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\confirm.png");
        confirm.setLayoutY(380);
        confirm.setLayoutX(360);
        Pane pane=new Pane();
        F_name.setAlignment(Pos.CENTER);
        F_password.setAlignment(Pos.CENTER);
        VBox vBox=new VBox(F_name,F_password,haveAccount);
        vBox.setLayoutX(25);
        vBox.setLayoutY(218);
        F_name.setScaleY(1.5);
        vBox.setSpacing(50);
        F_password.setScaleY(1.5);
        Image backgroundimg=new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\page\\base.png");
        BackgroundImage backgroundImage=new BackgroundImage(backgroundimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        pane.getChildren().addAll(exit,vBox,confirm);
        exit.setX(580);
        exit.setY(20);
        pane.setOnMouseClicked(event -> {
            AudioClip media=new AudioClip("file:C:/Users/USER/Desktop/God/games/game/Data/button/click.mp3");
            media.play(20);
        });
        haveAccount.setOnMouseClicked(event -> {
            stage.close();
            login.stage().show();
        });
        confirm.setOnMouseClicked(event -> {
            if(!Player.addPlayer(F_name.getCharacters().toString(),F_password.getCharacters().toString()));
            {
                Player account=Player.get(F_name.getCharacters().toString(),F_password.getCharacters().toString());
                MainPage.stage(account).show();
                stage.close();
            }
        });
        Scene scene=new Scene(pane,643,471);
        stage.setScene(scene);
        stage.setResizable(false);
        return stage;
    }
}
