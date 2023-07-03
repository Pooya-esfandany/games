package Data.build;

import Data.AttackData.UnitLocation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Crusher extends Build implements Defence{

        public int attackSpeed;
        String baseLocation;
        ImageView defaultMode;
        ImageView Attacking;
        public int damage;
        public int range;

        int maxLevel=10;
        int id;

        public Crusher(String location, int hp, String tower, int damage, int attackSpeed, int range,int id) {
            super(hp, tower);
            this.baseLocation=super.baseUrl+"Defence\\"+location+"\\";
            this.id=id;
            this.defaultPhoto=new ImageView(new Image(baseLocation+"default.png"));
            this.attackSpeed=attackSpeed;
            this.damage =damage;
            this.range=range;

        }
        public void Default()
        {
            super.defaultPhoto.setImage(defaultMode.getImage());
        }
        public void Attack() {
            super.defaultPhoto.setImage(Attacking.getImage());
        }
        public void upgrade() {
            if (haveUpgrade()) {
                damage = damage +50;
                level++;
                hp = hp + 100;
            }
        }
        public boolean haveUpgrade()
        {
            if(maxLevel==level)
                return false;
            return true;
        }

        @Override
        public int ID() {
            return id;
        }

    @Override
    public void Attack(UnitLocation unitLocation) {
            unitLocation.unit.hp=unitLocation.unit.hp-damage;
    }

    @Override
    public boolean InRange(UnitLocation unit) {
        if(this.X-range< unit.x &&this.X+range> unit.x)
        {

            if(this.Y+range>unit.y&&this.Y-range<=unit.y)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBusy() {
        return false;
    }
}

