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
    }
    public boolean destroyed()   {
        if(build.hp<=0)
        {
            return true;
        }
        return false;

    }

}
