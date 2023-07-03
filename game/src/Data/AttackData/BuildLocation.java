package Data.AttackData;

import Data.build.Build;
import Data.build.Builds;

public class BuildLocation {
    public int x;
    public int y;
    public Build build;
    public BuildLocation(int x, int y, int id)
    {

        this.build= Builds.getByID(id);
        this.x=x*100+50;
        this.y=y*100+50;
        build.X=this.x;
        build.Y=this.y;
    }
    public boolean destroyed()   {
        if(build.hp<=0)
        {
            build.destroyed();
            return true;
        }
        return false;

    }

}
