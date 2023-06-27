package Data.build;


import javafx.scene.image.ImageView;

public abstract class Build {
    int hp;
    int level;
    final  public  String baseUrl="file:C:\\Users\\USER\\Desktop\\God\\games\\game\\Data\\tower\\";
    Tower tower;
    public ImageView defaultPhoto;
    Build(int x,int y,int hp,String tower)
    {
        this.X=x;
        this.Y=y;
        level=0;
        this.hp=hp;
        this.tower=Tower.valueOf(tower);
    }
    public int X;
    public int Y;
}
