package Data.build;

import javafx.scene.image.ImageView;

public class Camp extends Build{
    public int capacity=5;

    public Camp(String tower, int hp) {
        super(hp, tower);
        this.defaultPhoto=new ImageView("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\tower\\camp\\camp.png");
    }
    public boolean haveUpgrade()
    {
        if(level<10)
        {
            return true;
        }
        return false;
    }
    public void upgrade()
    {
        if(haveUpgrade())
        {level++;
        capacity=level+1;
        cost+=cost+1000;
    }
    }

    @Override
    public int ID() {
        return 2;
    }
}
