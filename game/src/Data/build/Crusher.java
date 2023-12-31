package Data.build;

import Data.AttackData.UnitLocation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Crusher extends Build implements Defence{

        public int attackSpeed;
        String baseLocation;
        public int damage;
        public int range;

        int maxLevel=10;
        int id;

        public Crusher(String location, int hp, String tower, int damage, int attackSpeed, int range,int id) {
            super(hp, tower);
            this.baseLocation=super.baseUrl+"Defence\\"+location+"\\";
            this.id=id;
            this.defaultPhoto=new ImageView(new Image(baseLocation+"default.png"));
            this.defaultImage=new ImageView(new Image(baseLocation+"default.png"));
            this.AttackImage=new ImageView(new Image(baseLocation+"attack.png"));
            this.attackSpeed=attackSpeed;
            this.damage =damage;
            this.range=range;

        }
        ImageView defaultImage;
        ImageView AttackImage;
        public void upgrade() {
            if (haveUpgrade()) {
                cost+=1000;
                damage = damage +500;
                level++;
                hp = hp + 3000;
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
            AttackMode();
    }

    @Override
    public boolean InRange(UnitLocation unit) {
        if(this.X-range-50< unit.x &&this.X+range-50> unit.x)
        {

            if(this.Y+range+50>unit.y&&this.Y-range+50<=unit.y)
            {
                AttackMode();
                return true;
            }
        }
        DefaultMode();
        return false;
    }
    private void AttackMode()
    {
        defaultPhoto.setImage(AttackImage.getImage());
    }
    private void DefaultMode()
    {
        defaultPhoto.setImage(defaultImage.getImage());
    }

    @Override
    public boolean isBusy() {
        return false;
    }
}

