package Data.build;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Base  extends Build{


    public Base(int x, int y, int hp, String tower) {
        super(x,y,hp, tower);
        super.defaultPhoto=new ImageView(super.baseUrl+"base\\base.png");
    }
}
