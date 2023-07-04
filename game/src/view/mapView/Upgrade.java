package view.mapView;

import Data.Player;
import Data.build.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        Build upgradeBuild=Builds.getByID(buildID+1);
        Pane pane=new Pane();
        int level=buildID%10;
        Text text=new Text("do you want to upgrate it to"+(level+2));
        ImageView upgrade=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\upgrade.png");
        text.setLayoutX(250);
        text.setLayoutY(30);
        text.setScaleX(3);
        text.setScaleY(2);
        StackPane stackPane=new StackPane();
        stackPane.getChildren().add(upgrade);
        Text cost=new Text(Integer.toString(build.cost));
        cost.setScaleX(3);
        cost.setScaleY(3);

        stackPane.getChildren().add(cost);
        stackPane.setLayoutX(230);
        stackPane.setLayoutY(350);
        Scene scene=new Scene(pane,643,471);
        Image backgroundimg=new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\page\\upgrade.png");
        BackgroundImage backgroundImage=new BackgroundImage(backgroundimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        pane.getChildren().add(stackPane);
        pane.getChildren().add(text);
        VBox vBox=new VBox();
        Text currentHp=new Text("HP :"+Integer.toString(build.hp));
        ImageView imageView=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\arrow.png");
        Text nextHp=new Text("HP :"+Integer.toString(upgradeBuild.hp));
        HBox Hp=new HBox(currentHp,imageView,nextHp);
        vBox.getChildren().add(Hp);
        if(build instanceof Defence)
        {
            Text firstDamage=null;
            Text nextDamage=null;
            if(build instanceof Cannon)
            {
                 firstDamage=new Text("Damage :"+((Cannon) build).damage);
                 nextDamage=new Text(("Damage :"+((Cannon) upgradeBuild).damage));
            }
            if(build instanceof Crusher)
            {
                firstDamage=new Text("Damage :"+((Crusher) build).damage);
                nextDamage=new Text(("Damage :"+((Crusher) upgradeBuild).damage));
            }
            ImageView arrow=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\arrow.png");
            HBox hBox=new HBox();
            hBox.getChildren().addAll(firstDamage,arrow,nextDamage);
            vBox.getChildren().add(hBox);
        }
        if(build instanceof Camp)
        {
            Text currentCapacity=null;
            Text nextCapacity=null;
                currentCapacity=new Text("Capacity :"+((Camp) build).capacity);
                nextCapacity=new Text(("Capacity :"+((Camp) upgradeBuild).capacity));
            ImageView arrow=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\button\\arrow.png");
            HBox hBox=new HBox();
            hBox.getChildren().addAll(currentCapacity,arrow,nextCapacity);
            vBox.getChildren().add(hBox);
        }
        Hp.setAlignment(Pos.CENTER);
        Hp.setLayoutY(230);
        Hp.setLayoutX(150);
        pane.getChildren().add(vBox);
        vBox.setLayoutY(150);
        vBox.setLayoutX(200);
        stackPane.setOnMouseClicked(event -> {
            if(build.haveUpgrade())
            {
                if(player.currentMoney<build.cost)
                {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("purchase failed");
                    alert.setHeaderText("you dont have enough money");
                    alert.showAndWait();
                }
                else{
                player.mapData.safeZone[x][y]=buildID+1;
                player.currentMoney= player.currentMoney-build.cost;

            }
        }   MainPage.stage(player).show();
                    stage.close();
        }
        );
        stage.setScene(scene);
        return stage;
    }

}
