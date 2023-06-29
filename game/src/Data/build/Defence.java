package Data.build;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Defence extends Build implements Cloneable {
int attackSpeed;
String baseLocation;
 ImageView defaultMode;
ImageView attack_L;
ImageView attack_R;
ImageView attack_U;
ImageView attack_D;
int Damage;
int range;

int maxLevel=10;
int id;

    public Defence(String location, int hp, String tower, int damage, int attackSpeed, int range,int id) {
        super(hp, tower);
        this.baseLocation=super.baseUrl+"Defence\\"+location+"\\";
        this.id=id;
        this.defaultPhoto=new ImageView(new Image(baseLocation+"default.png"));
        this.attackSpeed=attackSpeed;
        this.Damage=damage;
        this.range=range;
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
        Damage = Damage +50;
        level++;
        hp = hp + 100;
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
}
