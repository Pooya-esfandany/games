package view.attack;

import Data.AttackData.BuildLocation;
import Data.AttackData.InHandUnit;
import Data.AttackData.Move;
import Data.AttackData.UnitLocation;
import Data.Player;
import Data.build.Builds;
import Data.unit.Unit;
import Data.unit.Units;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Attack {
    public static int current = 1;
    public static ArrayList<BuildLocation> locations=new ArrayList<>();
    public static ArrayList<UnitLocation> unitLocations=new ArrayList<>();
    public static Player defender;
    public static ArrayList<ImageView> views = new ArrayList<>();

    public static Stage stage(InHandUnit units, Player Attacker, Player Defender) {
        defender=Defender;
        Stage stage = new Stage();
        Pane pane = new Pane();
        locations=Defender.mapData.getLocation();
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\ground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (Defender.mapData.safeZone[i][j] != -1) {
                    views.add((Builds.getByID(Defender.mapData.safeZone[i][j]).defaultPhoto));
                    views.get(views.size() - 1).setLayoutY(j * 100);
                    views.get(views.size() - 1).setLayoutX(i * 100);
                }
            }
        }
        ImageView enhancer = new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\Es.jpg");
        ImageView wizard = new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\Ws.jpg");
        ImageView knight = new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\Ks.jpg");
        ImageView archer = new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\As.jpg");
        pane.getChildren().addAll(views);
        StackPane enhancerPane = new StackPane();
        StackPane wizardPane = new StackPane();
        StackPane knightPane = new StackPane();
        StackPane archerPane = new StackPane();
        Button ArcherButton = new Button(Integer.toString(units.getArcher()));
        Button wizardButton = new Button(Integer.toString(units.getWizard()));
        Button KnightButton = new Button(Integer.toString(units.getKnight()));
        Button enchantressButton = new Button(Integer.toString(units.getEnchantress()));
        enhancerPane.getChildren().addAll(enhancer, enchantressButton);
        enhancerPane.setAlignment(Pos.BOTTOM_CENTER);
        wizardPane.getChildren().addAll(wizard, wizardButton);
        wizardPane.setAlignment(Pos.BOTTOM_CENTER);
        knightPane.getChildren().addAll(knight, KnightButton);
        knightPane.setAlignment(Pos.BOTTOM_CENTER);
        archerPane.setAlignment(Pos.BOTTOM_CENTER);
        archerPane.getChildren().addAll(archer, ArcherButton);
        ArcherButton.setOnMouseClicked(event -> {
            current = 3;
        });
        wizardButton.setOnMouseClicked(event -> {
            current = 4;
        });
        enchantressButton.setOnMouseClicked(event -> {
            current = 2;
        });
        KnightButton.setOnMouseClicked(event -> {
            current = 1;
        });
        HBox box = new HBox();
        pane.getChildren().add(box);
        pane.setOnMouseClicked(event -> {
            if (units.haveUnit(current)) {
                Unit unit = units.get(current);
                UnitLocation unitLocation = new UnitLocation(unit, (int) event.getX()-50, (int) event.getY()+50);
                pane.getChildren().add(unitLocation.unit.currentPose);
                unitLocation.unit.currentPose.setLayoutY(event.getY()-50);
                unitLocation.unit.currentPose.setLayoutX(event.getX()-50);
                 ArcherButton.setText(Integer.toString(units.getArcher()));
                 wizardButton.setText(Integer.toString(units.getWizard()));
                 KnightButton.setText(Integer.toString(units.getKnight()));
                 enchantressButton.setText(Integer.toString(units.getEnchantress()));
                 if(!units.haveUnit(1))
                 {
                     box.getChildren().remove(knightPane);
                 }
                if(!units.haveUnit(2))
                {
                    box.getChildren().remove(enhancerPane);
                }
                if(!units.haveUnit(3))
                {
                    box.getChildren().remove(archerPane);
                }
                if(!units.haveUnit(4))
                {
                    box.getChildren().remove(wizardPane);
                }
                unitLocations.add(unitLocation);

                UnitThread thread=new UnitThread(locations,unitLocation);
                thread.start();
            }

        });

        box.getChildren().addAll(archerPane, enhancerPane, knightPane, wizardPane);
        box.setLayoutY(600);
        Scene scene = new Scene(pane, 700, 700);
        stage.setScene(scene);
        return stage;
    }


}