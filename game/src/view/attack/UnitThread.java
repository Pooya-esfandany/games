package view.attack;

import Data.AttackData.BuildLocation;
import Data.AttackData.UnitLocation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class UnitThread extends Thread{
    private static boolean notFinished =true;
    private UnitLocation unitLocation;
    private ArrayList<BuildLocation> buildLocations=new ArrayList<>();
    @Override
    public void run()
    {
        while(notFinished)
        {
            int distanceX=0;
            int distanceY=0;
            boolean left;
;
            BuildLocation closestBuild=unitLocation.closestBuild(buildLocations);
            int speed=unitLocation.unit.movementSpeed;

            double time=Math.sqrt(distanceY*distanceY+distanceX*distanceX)/(speed);
            if(unitLocation.unit.isDead())
            {
                unitLocation.unit.Dead();
            }
            else{
            if(closestBuild.x>unitLocation.x)
            {
                unitLocation.unit.WalkingRight();

                distanceX=-unitLocation.x+closestBuild.x-50;

            }
            if(closestBuild.x<unitLocation.x)
            {
                unitLocation.unit.WalkingLeft();
                left=true;
                 distanceX=closestBuild.x-unitLocation.x-50;

            } else {
                left = false;
            }
            if(closestBuild.y>unitLocation.y)
            {
                distanceY=-unitLocation.y+closestBuild.y+50;
            }
            if(closestBuild.y<unitLocation.y)
            {
                distanceY=closestBuild.y-unitLocation.y+50;
            }

            TranslateTransition translateTransition=new TranslateTransition();
            translateTransition.setDuration(Duration.millis(speed));
            translateTransition.setNode(unitLocation.unit.currentPose);
            translateTransition.setByY(distanceY);
            translateTransition.setByX(distanceX);
            translateTransition.play();
            int finalDistanceY = distanceY;
            int finalDistanceX = distanceX;
            translateTransition.setOnFinished(event -> {
                if(!unitLocation.unit.isDead()){
                unitLocation.y=unitLocation.y+ finalDistanceY;
                unitLocation.x=unitLocation.x+ finalDistanceX;
                if(left)
                {
                    unitLocation.unit.AttackLeft();
                }
                else
                {
                    unitLocation.unit.AttackRight();
                }


                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    public void run() {
                        unitLocation.unit.Attack(closestBuild);try {
                            if(closestBuild.destroyed())
                            {
                                Exception exception=new Exception();
                                throw exception;
                            }
                        } catch (Exception e) {
                            closestBuild.build.destroyed();
                            buildLocations.remove(closestBuild);
                            timer.cancel();
                            UnitThread unitThread=new UnitThread(buildLocations,unitLocation);
                            unitThread.start();
                        }
                    }
                };
                timer.scheduleAtFixedRate(task, 0, unitLocation.unit.attackSpeed);
            }});
            break;
        }
    }}
    public UnitThread(ArrayList<BuildLocation> buildLocations,UnitLocation unitLocation)
    {
        this.unitLocation=unitLocation;
        this.buildLocations=buildLocations;
    }
}
