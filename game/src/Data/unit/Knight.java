package Data.unit;

import Data.AttackData.BuildLocation;

public class Knight extends Unit {

        public Knight(String unit, int hp, int damage, int attackSpeed, int movementSpeed, int range) {
            super(unit, hp, damage, attackSpeed, movementSpeed, range);
             savedHp=hp;
        }
        int savedHp;
        @Override
        public void Attack(BuildLocation buildLocation)
        {
            int extraDamage=extraDamageCalculator();
            buildLocation.build.hp-=damage+extraDamage;
        }
        private int extraDamageCalculator()
        {
            int lostHp=savedHp-hp;
            return (int)(lostHp*0.03);
        }
    }

