package Data.AttackData;

import Data.unit.Unit;

public class UnitLocation {
    Unit unit;
    int x;
    int y;
    int range;
    UnitLocation(Unit unit,int x,int y )
    {
        this.x=x;
        this.y=y;
        this.unit=unit;
        this.range=unit.range;
    }
    public void refresh(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public boolean inRange(BuildLocation buildLocation)
    {
        int Y= buildLocation.y-y;
        int X= buildLocation.x-x;
        int total=(int)Math.sqrt(Math.pow(X,2)+Math.pow(Y,2));
        if(total<range)
        {
            return true;
        }
        return false;
    }


}
