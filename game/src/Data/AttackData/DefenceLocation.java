package Data.AttackData;

import Data.build.Build;
import Data.build.Cannon;
import Data.build.Crusher;
import Data.build.Defence;

public class DefenceLocation {
    public int x;
    public boolean isDestroyed=false;
    public boolean isBusy()
    {
        if(build instanceof  Cannon)
        {
            return ((Cannon)(build)).isBusy();
        }
        if(build instanceof Crusher)
        {
            return false;
        }
        return true;
    }
    public Build build;
    public boolean InRange(UnitLocation unitLocation)
    {
        if(build instanceof Cannon)
        {
            return ((Cannon)(build)).InRange(unitLocation);
        }
        if(build instanceof Crusher)
        {
            return ((Crusher)(build)).InRange(unitLocation);
        }
        return false;
    }
    public void Attack(UnitLocation unitLocation)
    {

        if(build instanceof Cannon)
        {
             ((Cannon)(build)).Attack(unitLocation);

        }
        if(build instanceof Crusher)
        {
             ((Crusher)(build)).Attack(unitLocation);
        }

    }
    public int speed;
    public int y;
    public int range;
    int damage;
    public DefenceLocation(BuildLocation buildLocation)
    {
        this.build=buildLocation.build;
        if(buildLocation.build instanceof Cannon)
        {
            this.x=buildLocation.x;
            this.y= buildLocation.y;
            this.damage=((Cannon)(buildLocation.build)).damage;
            this.range=((Cannon)(buildLocation.build)).range;
            this.speed=((Cannon)(buildLocation.build)).attackSpeed;
        }
        if(buildLocation.build instanceof Crusher)
        {
            this.x=buildLocation.x;
            this.y= buildLocation.y;
            this.damage=((Crusher)(buildLocation.build)).damage;
            this.range=((Crusher)(buildLocation.build)).range;
            this.speed=((Crusher)(buildLocation.build)).attackSpeed;
        }
    }

}
