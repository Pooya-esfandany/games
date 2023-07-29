package view.attack;

import Data.Player;
import Data.unit.Archer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.mapView.MainPage;

import java.util.ArrayList;


public class Result {
    public static Stage stage(Player player, int totalBuild, int notDestroyedBuild)
    {
        Stage stage=new Stage();
        ImageView star1=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\result\\1.png");
        ImageView star2=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\result\\2.png");
        ImageView star3=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\result\\3.png");
        ImageView star4=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\result\\4.png");
        ImageView star5=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\result\\5.png");
        ImageView main=new ImageView();
        int destroyedBuild=totalBuild-notDestroyedBuild;
        Attack.locations=new ArrayList<>();
        Attack.defenceLocation=new ArrayList<>();
        Attack.unitLocations=new ArrayList<>();
        double percent=(((double)(destroyedBuild))/((double)(totalBuild)))*100;
        if(percent<20)
            main.setImage(star1.getImage());
        if(percent>=20&&percent<40)
            main.setImage(star2.getImage());
        if(percent>=40 &&percent<60)
            main.setImage(star3.getImage());
        if(percent>=60 && percent<80)
            main.setImage(star4.getImage());
        if(percent>=80)
            main.setImage(star5.getImage());
        Pane pane=new Pane(main);
        Scene scene=new Scene(pane);
        Archer.matchFinished();
        scene.setOnMouseClicked(event -> {
            player.totalMatch++;
            if(percent>=60)
            {
                player.win++;
                player.currentMoney+=500000;
            }
            stage.close();
            MainPage.stage(player).show();
        });
        stage.setScene(scene);
        return stage;
    }

}
