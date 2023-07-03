package Data.AttackData;

import Data.unit.Unit;

import java.util.ArrayList;

public class UnitLocation {
    public Unit unit;
    public int x;
    public int y;
    int range;
    public UnitLocation(Unit unit, int x, int y)
    {
        this.x=x;
        this.y=y;
        this.unit=unit;
        this.range=unit.range;
    }



    public BuildLocation closestBuild(ArrayList<BuildLocation> locations)
    {
        int minX;
        int minLocation=0;
        if(locations.get(0).x>x)
        {
            minX=locations.get(0).x-x;
        }
        else
        {
            minX=x-locations.get(0).x;
        }
        int minY;
        if(locations.get(0).y>y)
        {
            minY=locations.get(0).y-y;
        }
        else
        {
            minY=y-locations.get(0).y;
        }

        for(int i=1;i<locations.size();i++)
        {
            int currentX=0;
            int currentY=0;
            if(locations.get(i).x>x)
            {
                currentX=locations.get(i).x-x+50;
                unit.WalkingRight();
            }
            else
            {
                currentX=x-locations.get(i).x-50;
                unit.WalkingLeft();
            }
            if(locations.get(i).y>y)
            {
                currentY=locations.get(i).y-y+50;
            }
            else
            {
                currentY=y-locations.get(i).y-50;
            }
            int minDistance=((minX*minX)+(minY*minY));
            int currentDistance=(currentX*currentX)+(currentY*currentY);

            if(minDistance>currentDistance)
            {
                minX=currentX;
                minY=currentY;
                minLocation=i;
            }
        }

        return locations.get(minLocation);
    }

}
