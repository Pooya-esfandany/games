package view.attack;

import Data.AttackData.BuildLocation;
import Data.AttackData.DefenceLocation;
import Data.AttackData.UnitLocation;
import Data.build.Cannon;
import Data.build.Crusher;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DefenceThread extends Thread{
    DefenceLocation defenceLocation;
    UnitLocation unitLocation;
    @Override
    public void run() {Timer timer = new Timer();
         {

            if (defenceLocation.build instanceof Cannon) {
                ((Cannon) (defenceLocation.build)).busy = true;
            }
            TimerTask task = new TimerTask() {
                public void run() {
                    if(defenceLocation.build.hp>0)
                    {
                    defenceLocation.Attack(unitLocation);
                    if (unitLocation.unit.isDead()) {
                        unitLocation.unit.Dead();
                        timer.cancel();
                        Attack.unitLocations.remove(unitLocation);
                        if (defenceLocation.build instanceof Cannon) {
                            ((Cannon) (defenceLocation.build)).busy = false;
                        }
                    }
                }}
            };
            timer.schedule(task, 0, defenceLocation.speed);
        }
    }
    DefenceThread(DefenceLocation defenceLocation,UnitLocation unitLocation)
    {
        this.defenceLocation=defenceLocation;
        this.unitLocation=unitLocation;
    }



}
