package Data.unit;

import Data.AttackData.BuildLocation;

public class Enchantress extends Unit{
    public Enchantress(String unit, int hp, int damage, int attackSpeed, int movementSpeed, int range) {
        super(unit, hp, damage, attackSpeed, movementSpeed, range);
    }



        @Override
        public void Attack(BuildLocation buildLocation)
        {
            int cricticalDamage=(int)(Math.random()*2)+1;
                buildLocation.build.hp-=damage+cricticalDamage*damage*2;
        }
    }

