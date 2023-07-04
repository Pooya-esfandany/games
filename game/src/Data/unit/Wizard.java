package Data.unit;

import Data.AttackData.BuildLocation;

public class Wizard extends Unit{
    public Wizard(String unit, int hp, int damage, int attackSpeed, int movementSpeed, int range) {
        super(unit, hp, damage, attackSpeed, movementSpeed, range);
    }
    @Override
    public void Attack(BuildLocation buildLocation)
    {
        int extraDamage=(int)(buildLocation.build.hp*0.3);
        buildLocation.build.hp-=extraDamage+damage;
    }

}
