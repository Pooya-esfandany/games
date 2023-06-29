package Data.build;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Base  extends Build{


    @Override
    public int ID() {
        return 0;
    }

    @Override
    public void upgrade() {
        level++;
        if (haveUpgrade()) {
            hp += 500;
        }
    }

    @Override
    public boolean haveUpgrade() {
        if(level<10)
            return true;
        return false;
    }

    public Base( int hp, String tower) {
        super(hp, tower);
        super.defaultPhoto=new ImageView(super.baseUrl+"base\\base.png");
    }
}
