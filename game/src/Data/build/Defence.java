package Data.build;

import javafx.scene.image.ImageView;

public class Defence extends Build{
int attackSpeed;
String baseLocation;
ImageView defaultView;
ImageView attack_L;
ImageView attack_R;
ImageView attack_U;
ImageView Attack_D;
int Damage;
int range;
int level=0;
int maxLevel=10;
public void upgrade() {
    if (haveUpgrade()) {
        Damage = Damage + 10;
        level++;
        hp = hp + 100;
        this.attackSpeed = attackSpeed - 20;
    }
}
boolean haveUpgrade()
{
    if(maxLevel==level)
        return false;
    return true;
}
}
