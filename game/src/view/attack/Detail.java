package view.attack;

import Data.unit.Unit;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;




public class Detail {
    public static Stage stage(ImageView imageView, Unit unit)
    {
        Stage stage=new Stage();
        HBox attackBox=new HBox();
        ImageView attack=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\unit\\show\\damage.png");
        Text attackDamage=new Text(Integer.toString(unit.damage));
        attackBox.getChildren().addAll(attack,attackDamage);
        HBox hpBox=new HBox();
        ImageView hp=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\unit\\show\\hp.png");
        Text hpNumber=new Text(Integer.toString(unit.hp));
        hpBox.getChildren().addAll(hp,hpNumber);
        HBox speedBox=new HBox();
        ImageView speed=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\unit\\show\\time.png");
        Text attackSpeed=new Text(Integer.toString(unit.attackSpeed));
        speedBox.getChildren().addAll(speed,attackSpeed);
        VBox detail=new VBox();
        detail.getChildren().addAll(attackBox,hpBox,speedBox);
        VBox total=new VBox();
        total.getChildren().addAll(imageView,detail);
        Scene scene=new Scene(total);
        stage.setScene(scene);
        return stage;
    }

}
