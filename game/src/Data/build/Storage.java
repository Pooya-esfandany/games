package Data.build;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Storage extends Build  {
    String url=baseUrl+"Storage\\";
    int maxCapacity;
    int currentMoney;
    ImageView empty;
    ImageView notALot;
    ImageView half;
    ImageView Full;

    public Storage(int hp, String tower, int capacity) {
        super(hp, tower);
        this.maxCapacity=capacity;
        empty=new ImageView(url+"1.png");

        notALot=new ImageView(url+"2.png");
        half=new ImageView(url+"3.png");
        Full=new ImageView(url+"4.png");
        super.defaultPhoto=current();
    }
    ImageView current()
    {
        if(maxCapacity/4>currentMoney)
            return empty;
        if(maxCapacity/2>currentMoney)
            return notALot;
        if(3*maxCapacity/4>currentMoney)
            return half;
        return Full;
    }

    @Override
    public int ID() {
        return 3;
    }

    @Override
    public void upgrade() {
        if(haveUpgrade()){
        this.maxCapacity+=2000;
        hp+=100;
    }
    }


    @Override
    public boolean haveUpgrade() {
        if(level<10)
        {
            return true;
        }
        return false;
    }
}
