package Data.build;

import Data.AttackData.UnitLocation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public  class Cannon extends Build implements Defence  {
public int attackSpeed;
String baseLocation;
 ImageView defaultMode;
ImageView attack_L;
ImageView attack_R;
ImageView attack_U;
ImageView attack_D;
public int damage;
public int range;
public boolean busy;
int maxLevel=10;
int id;

    public Cannon(String location, int hp, String tower, int damage, int attackSpeed, int range, int id) {
        super(hp, tower);
        this.baseLocation=super.baseUrl+"Defence\\"+location+"\\";
        this.id=id;
        this.defaultPhoto=new ImageView(baseLocation+"default.png");
        this.defaultMode=new ImageView(baseLocation+"default.png");
        this.attackSpeed=attackSpeed;
        this.damage =damage;
        this.range=range;
        this.busy=false;
        attack_L=new ImageView(baseLocation+"L.gif");
        attack_U=new ImageView(baseLocation+"U.gif");
        attack_R=new ImageView(baseLocation+"R.gif");
        attack_D=new ImageView(baseLocation+"D.gif");

    }
    public void Left()
    {
        super.defaultPhoto.setImage(attack_L.getImage());
    }
    public void Right()
    {
        super.defaultPhoto.setImage(attack_R.getImage());
    }
    public void Down()
    {
        super.defaultPhoto.setImage(attack_D.getImage());
    }
    public void Up()
    {
        super.defaultPhoto.setImage(attack_U.getImage());
    }
    public void Default()
    {
        super.defaultPhoto.setImage(defaultMode.getImage());
    }
    public void upgrade() {
    if (haveUpgrade()) {
        damage = damage +500;
        level++;
        hp = hp + 1000;
        cost+=1500;
    }
}
public boolean haveUpgrade()
{
    if(maxLevel==level)
        return false;
    return true;
}

    @Override
    public int ID() {
        return id;
    }

    @Override
    public void Attack(UnitLocation unitLocation) {
        unitLocation.unit.hp-=damage;
    }
    @Override
    public boolean InRange(UnitLocation unit)
    {
        Default();
        double totalX;
        double totalY;
        if(unit.x>this.X)
        {
            totalX=unit.x-this.X-50;
        }
        else
        {
            totalX=this.X-unit.x-50;
        }
        if(unit.y>this.Y)
        {
            totalY=unit.y-this.Y;
        }
        else
        {
            totalY=this.Y-unit.y;
        }

        double totalDistance=(totalY*totalY)+(totalX*totalX);
        double maxRange=this.range*this.range;
        if(totalDistance<maxRange)
        {
            if(totalY>totalX)
            {
                if(unit.y>this.Y)
                {
                    Down();
                }
                else
                {
                    Up();
                }
            }
            else
            {
                if(unit.x>this.X)
                {
                    Right();
                }
                else
                {
                    Left();
                }
            }
            return true;
        }
        Default();
        return false;
    }

    @Override
    public boolean isBusy() {
        return busy;
    }


}
