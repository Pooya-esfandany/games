package Data.build;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Build {
    public abstract int ID();
    public abstract void upgrade();
    public abstract boolean haveUpgrade();
    public int hp;
    public int cost=2000;
    public int level;
    final  public  String baseUrl="file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\tower\\";
    Tower tower;
    public ImageView defaultPhoto;
    Build(int hp,String tower)
    {
        level=1;
        this.hp=hp;
        this.tower=Tower.valueOf(tower);
    }
    public int X;
    public int Y;
    public void destroyed()
    {
        defaultPhoto.setImage(new Image("file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\tower\\boom.png"));
    }
}
