package Data.build;

import javafx.scene.image.ImageView;

public class Camp extends Build{
    int capacity=5;
    int maxLevel=10;
    public Camp(String tower, int hp) {
        super(hp, tower);
        this.defaultPhoto=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\tower\\camp\\camp.png");
    }
    public boolean haveUpgrade()
    {
        if(level<maxLevel)
        {
            return true;
        }
        return false;
    }
    public void upgrade()
    {
        if(haveUpgrade())
        {level++;
        capacity=level+5;
    }
    }

    @Override
    public int ID() {
        return 2;
    }
}
