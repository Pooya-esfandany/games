package Data.unit;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Unit {
    public static ArrayList<Unit> units=new ArrayList<>();
    private static String Url="file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\unit\\";
    private String baseUrl;
    public ImageView currentPose;
    ImageView L_Attack;
    ImageView R_Attack;
    ImageView R_walk;
    ImageView L_walk;
    ImageView Death;
    ImageView Dead;
    int Hp;
    public Unit(String unit,int hp,int damage,int attackSpeed,int movementSpeed,int range)
    {
        Hp=hp;
        this.attackSpeed=attackSpeed;
        this.damage=damage;
        this.movementSpeed=movementSpeed;
        this.Range=range;
        baseUrl=Url+unit+"\\";
        L_walk=new ImageView(baseUrl+"Walk-L.gif");
        R_walk=new ImageView(baseUrl+"Walk-R.gif");
        Death=new ImageView(baseUrl+"Death.gif");
        Dead=new ImageView(baseUrl+"Dead.gif");
        L_Attack =new ImageView(baseUrl+"Attack-L.gif");
        R_Attack=new ImageView(baseUrl+"Attack-R.gif");
    }
    int Range;
    int damage;
    int movementSpeed;
    int attackSpeed;
    public void WalkingLeft()
    {
        currentPose=L_walk;
    }
    public void WalkingRight()
    {
        currentPose=R_walk;
    }
    public void AttackLeft()
    {
        currentPose=L_Attack;
    }
    public void AttackRight()
    {
        currentPose=R_Attack;
    }
    public void Dead() {
        currentPose = Death;
        try {
            wait(2000);
            currentPose=Dead;
        }
        catch (Exception e)
        {

        }
    }

}
