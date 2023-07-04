package Data.unit;

import Data.AttackData.BuildLocation;

public class Archer extends Unit{
    private static int revenge=0;
    public Archer(String unit, int hp, int damage, int attackSpeed, int movementSpeed, int range) {
        super(unit, hp, damage, attackSpeed, movementSpeed, range);
    }
    @Override
    public void Attack(BuildLocation buildLocation)
    {
        int totalDamage=revenge*5+damage;
        buildLocation.build.hp-=damage;
    }
    @Override
    public boolean isDead()
    {
        if(hp<=0)
        {
            revenge++;
            return true;
        }
        return false;

    }
    public static void matchFinished()
    {
        revenge=0;
    }
}
