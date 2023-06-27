package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class login {
    public static Stage stage()
    {
        Stage stage=new Stage();
        ImageView imageView=new ImageView(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\Data\\unit\\walking.gif"));
        Pane pane=new Pane(imageView);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        return stage;
    }
}
