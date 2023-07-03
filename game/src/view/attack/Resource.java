package view.attack;

import Data.AttackData.BuildLocation;
import Data.AttackData.InHandUnit;
import Data.Player;
import Data.build.Camp;
import Data.unit.Unit;
import Data.unit.Units;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Resource {
    private static int capacity=0;
    private static int current=0;
    private static int enhancerNumber=0;
    private static int knightNumber=0;
    private static int wizardNumber=0;
    private static int archerNumber=0;
    private static String giveString()
    {
        current=enhancerNumber+knightNumber+wizardNumber+archerNumber;
        return (current+"/"+capacity);
    }
    public static Stage stage(Player player)
    {
        capacity=0;
        archerNumber=0;
        wizardNumber=0;
        knightNumber=0;
        enhancerNumber=0;
        ArrayList<BuildLocation> buildLocations =player.mapData.getLocation();
        for(int i = 0; i< buildLocations.size(); i++)
        {
            if(buildLocations.get(i).build instanceof Camp)
            {
                Camp build = (Camp) (buildLocations.get(i).build);
                capacity+=build.capacity;
            }
        }
        Button ArcherButton=new Button("0");
        ArcherButton.setScaleX(4);
        Button wizardButton=new Button("0");
        wizardButton.setScaleX(4);
        Button KnightButton=new Button("0");
        Button enchantressButton=new Button("0");
        KnightButton.setScaleX(4);
        enchantressButton.setScaleX(4);
        Stage stage=new Stage();
        ImageView enhancer =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\E.jpg");
        ImageView wizard =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\W.jpg");
        ImageView knight =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\K.jpg");
        ImageView archer =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\A.jpg");
        ImageView button =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\button.png");
        Text buttonTxt=new Text(giveString());
        StackPane attack=new StackPane(button);
        attack.getChildren().add(buttonTxt);
        StackPane enhancerPane=new StackPane();
        StackPane wizardPane=new StackPane();
        StackPane knightPane=new StackPane();
        StackPane archerPane=new StackPane();
        enhancerPane.getChildren().addAll(enhancer,enchantressButton);
        enhancerPane.setAlignment(Pos.BOTTOM_CENTER);
        wizardPane.getChildren().addAll(wizard,wizardButton);
        wizardPane.setAlignment(Pos.BOTTOM_CENTER);
        knightPane.getChildren().addAll(knight,KnightButton);
        knightPane.setAlignment(Pos.BOTTOM_CENTER);
        archerPane.setAlignment(Pos.BOTTOM_CENTER);
        archerPane.getChildren().addAll(archer,ArcherButton);
        wizardButton.setOnMouseClicked(event -> {
            if(capacity>current)
            {
                wizardNumber++;
                wizardButton.setText(Integer.toString(wizardNumber));
            buttonTxt.setText(giveString());
        }
        });
        ArcherButton.setOnMouseClicked(event -> {
            if(capacity>current)
            {
                archerNumber++;
                ArcherButton.setText(Integer.toString(archerNumber));
                buttonTxt.setText(giveString());
            }
        });
        enchantressButton.setOnMouseClicked(event -> {
            if(capacity>current)
            {enhancerNumber++;
                enchantressButton.setText(Integer.toString(enhancerNumber));

                buttonTxt.setText(giveString());
            }
        });
        KnightButton.setOnMouseClicked(event -> {
            if(capacity>current)
            {
                knightNumber++;
                KnightButton.setText(Integer.toString(knightNumber));
                buttonTxt.setText(giveString());
            }
        });
        button.setOnMouseClicked(event -> {

            InHandUnit inHandUnit=new InHandUnit(wizardNumber,knightNumber,archerNumber,enhancerNumber);
            stage.close();
            Player random=Player.random();
            Attack.stage(inHandUnit,player,random).show();
            Attack.lose=false;
            Attack.victory=false;
        });
        HBox Hbox=new HBox();
        Hbox.getChildren().addAll(archerPane,enhancerPane,knightPane,wizardPane);
        VBox vbox=new VBox();

        vbox.getChildren().addAll(Hbox,attack);
        Scene scene=new Scene(vbox);
        stage.setScene(scene);
        return stage;
    }

}
