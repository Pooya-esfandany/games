package Data.unit;

import Data.AttackData.BuildLocation;

public class Wizard extends Unit{
    public Wizard(String unit, int hp, int damage, int attackSpeed, int movementSpeed, int range) {
        super(unit, hp, damage, attackSpeed, movementSpeed, range);
    }
    @Override
    public void Attack(BuildLocation buildLocation)
    {
        buildLocation.build.hp*=0.7;
    }
}
