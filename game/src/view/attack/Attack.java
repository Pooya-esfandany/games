package view.attack;

import Data.Player;
import Data.build.Builds;
import Data.unit.Unit;
import Data.unit.Units;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Attack {
    public static Stage stage(ArrayList<Unit> units, Player Attacker,Player Defender)
    {
        Stage stage=new Stage();
        Pane pane=new Pane();
        ArrayList<ImageView> views=new ArrayList<>();

        BackgroundImage backgroundImage=new BackgroundImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\map\\ground.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++)
            {
                if(Defender.mapData.safeZone[i][j]!=-1)
                {
                    views.add((Builds.getByID(Defender.mapData.safeZone[i][j]).defaultPhoto));
                    views.get(views.size()-1).setLayoutY(j*100);
                    views.get(views.size()-1).setLayoutX(i*100);
                }
            }}
        ImageView enhancer =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\Es.jpg");
        ImageView wizard =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\Ws.jpg");
        ImageView knight =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\Ks.jpg");
        ImageView archer =new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\attack\\As.jpg");
        pane.getChildren().addAll(views);
        StackPane enhancerPane=new StackPane();
        StackPane wizardPane=new StackPane();
        StackPane knightPane=new StackPane();
        StackPane archerPane=new StackPane();
        Button ArcherButton=new Button("0");
        Button wizardButton=new Button("0");
        Button KnightButton=new Button("0");
        Button enchantressButton=new Button("0");
        enhancerPane.getChildren().addAll(enhancer,enchantressButton);
        enhancerPane.setAlignment(Pos.BOTTOM_CENTER);
        wizardPane.getChildren().addAll(wizard,wizardButton);
        wizardPane.setAlignment(Pos.BOTTOM_CENTER);
        knightPane.getChildren().addAll(knight,KnightButton);
        knightPane.setAlignment(Pos.BOTTOM_CENTER);
        archerPane.setAlignment(Pos.BOTTOM_CENTER);
        archerPane.getChildren().addAll(archer,ArcherButton);
        HBox box=new HBox();
        box.getChildren().addAll(archerPane,enhancerPane,knightPane,wizardPane);
        pane.getChildren().add(box);
        box.setLayoutY(600);
        Scene scene=new Scene(pane,700,700);
        stage.setScene(scene);
        return stage;
    }
}
