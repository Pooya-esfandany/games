package Gate;

import Data.AttackData.BuildLocation;
import Data.Player;
import Data.errors.NotEnoughCash;

public class Check {
    public static void money(Player player,int cost) throws NotEnoughCash {
        if(player.currentMoney<cost)
        {
            NotEnoughCash notEnoughCash=new NotEnoughCash();
            throw  notEnoughCash;
        }
        else {
            player.currentMoney-=cost;
        }
    }
}
