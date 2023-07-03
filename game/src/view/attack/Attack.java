package view.attack;

import Data.AttackData.*;
import Data.Player;
import Data.build.Builds;
import Data.build.Cannon;
import Data.build.Defence;
import Data.unit.Unit;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Attack {
    public static int current = 1;
    public static ArrayList<BuildLocation> locations=new ArrayList<>();
    public static ArrayList<UnitLocation> unitLocations=new ArrayList<>();
    public static Player defender;
    public static boolean victory;
    public static boolean lose;
    public static int totalBuilds;
    public static ArrayList<ImageView> views = new ArrayList<>();
    public static ArrayList<DefenceLocation> defenceLocation =new ArrayList<>();

    public static Stage stage(InHandUnit units, Player Attacker, Player Defender) {
        ;
        victory=false;
        locations=Defender.mapData.getLocation();
        defender=Defender;
        Stage stage = new Stage();
        Pane pane = new Pane();
        Timer timer = new Timer();
        defenceLocation =Defender.mapData.getDefenceLocation();
        totalBuilds=locations.size();
        TimerTask task = new TimerTask() {
            public void run() {
                if(unitLocations.size()==0&&units.finished())
                {
                    lose=true;
                }
                if(victory||lose)
                {
                    if(locations.size()==0)
                    {
                        Attack.victory=true;
                    }

                    lose=false;
                    victory=false;
                    views=new ArrayList<>();
                    try {
                        timer.cancel();
                        CloseStage closeStage=new CloseStage(Attacker,stage);
                        closeStage.close();
                    }catch (Exception e)
                    {

                    }
                }
                if(unitLocations.size()>0)
                {
                    for(int i=0;i<defenceLocation.size();i++)
                    {
                        if(defenceLocation.get(i).isDestroyed)
                        {
                            defenceLocation.get(i).build.destroyed();
                            defenceLocation.remove(i);
                            break;
                        }
                    }
                for(int i = 0; i< defenceLocation.size(); i++) {
                    for (int j = 0; j < unitLocations.size(); j++)
                    {
                        if(!defenceLocation.get(i).isBusy()) {
                            if (defenceLocation.get(i).InRange(unitLocations.get(j))) {
                                DefenceThread defenceThread = new DefenceThread(defenceLocation.get(i), unitLocations.get(j));
                                defenceThread.start();
                                if(defenceLocation.get(i).build instanceof Cannon)
                                {
                                    break;
                                }
                            }
                        }
                    }

                }

            }}
        };
        timer.schedule(task,0,1000);
        locations=Defender.mapData.getLocation();
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\ground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));

        for(int i=0;i<locations.size();i++)
        {
            if(!(locations.get(i).build instanceof Defence)) {
                ImageView view = locations.get(i).build.defaultPhoto;
                view.setLayoutX(locations.get(i).x - 50);
                view.setLayoutY(locations.get(i).y - 50);
                views.add(view);
            }
        }
        for(int i=0;i<defenceLocation.size();i++)
        {
                ImageView view = defenceLocation.get(i).build.defaultPhoto;
                view.setLayoutX(defenceLocation.get(i).x - 50);
                view.setLayoutY(defenceLocation.get(i).y - 50);
                views.add(view);
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
        stage.setResizable(false);
        return stage;
    }


}
