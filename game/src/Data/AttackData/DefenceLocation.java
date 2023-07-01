package Data.AttackData;

import Data.build.Defence;

public class DefenceLocation {
    int x;
    Defence defence;
    int y;
    int range;
    int damage;
    DefenceLocation(int x,int y,BuildLocation buildLocation)
    {
        this.x=x;
        this.y=y;
        this.range=((Defence)(buildLocation.build)).range;
        this.defence =((Defence)(buildLocation.build));
        this.damage=((Defence)(buildLocation.build)).damage;
    }
    public boolean inRange(UnitLocation unit)
    {
        int Y= y-unit.y;
        int X= x- unit.x;
        int distance=(int)(Math.sqrt((Math.pow(Y,2))+Math.pow(X,2)));
        if(distance<range)
        {
        if(Math.abs(Y)>Math.abs(X))
        {
            if(Y<0)
            {
                defence.Down();
            }
            else
            {
                defence.Up();
            }
        }
        else {
            if(X>0)
            {
                defence.Left();
            }
            else
                defence.Right();
        }
            return true;
    }
    return false;
    }

}
