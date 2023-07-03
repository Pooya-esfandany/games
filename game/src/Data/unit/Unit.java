package Data.unit;

import Data.AttackData.BuildLocation;
import javafx.scene.image.ImageView;

public class Unit {
    private static String Url="file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\unit\\";
    private String baseUrl;
    public ImageView currentPose;
    ImageView L_Attack;
    ImageView R_Attack;
    ImageView R_walk;
    ImageView L_walk;
    ImageView Death;
    ImageView Dead;
    public int hp;
    public Unit(String unit,int hp,int damage,int attackSpeed,int movementSpeed,int range)
    {
        this.hp =hp;
        this.attackSpeed=attackSpeed;
        this.damage=damage;
        this.movementSpeed=movementSpeed;
        this.range =range;
        baseUrl=Url+unit+"\\";
        L_walk=new ImageView(baseUrl+"Walk-L.gif");
        currentPose=new ImageView(baseUrl+"Walk-L.gif");
        R_walk=new ImageView(baseUrl+"Walk-R.gif");
        Death=new ImageView(baseUrl+"Death.gif");
        Dead=new ImageView(baseUrl+"Dead.gif");
        WalkingRight();
        L_Attack =new ImageView(baseUrl+"Attack-L.gif");
        R_Attack=new ImageView(baseUrl+"Attack-R.gif");
    }
    public int range;
    public int damage;
    public int movementSpeed;
    public int attackSpeed;
    public void WalkingLeft()
    {
        currentPose.setImage(L_walk.getImage());
    }
    public void WalkingRight()
    {
        currentPose.setImage(R_walk.getImage());
    }
    public void AttackLeft()
    {
        currentPose.setImage(L_Attack.getImage());
    }
    public void AttackRight()
    {
        currentPose.setImage(R_Attack.getImage());
    }
    public void Dead() {
        currentPose.setImage(Dead.getImage());
    }
    public void Attack(BuildLocation buildLocation)
    {
        buildLocation.build.hp=buildLocation.build.hp-damage;

    }
    public boolean isDead()
    {
        if(hp<=0)
        {
            return true;
        }
        return false;

    }
}
