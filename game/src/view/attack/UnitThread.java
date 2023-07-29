package view.attack;

import Data.AttackData.BuildLocation;
import Data.AttackData.DefenceLocation;
import Data.AttackData.UnitLocation;
import Data.build.Cannon;
import Data.build.Defence;
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
        while(!unitLocation.unit.isDead())
        {
            double distanceX=0;
            double distanceY=0;
            boolean left;
            if(buildLocations.size()==0)
            {
                if(Attack.victory=true)
                    break;
            }
            BuildLocation closestBuild=unitLocation.closestBuild(buildLocations);
            int speed=unitLocation.unit.movementSpeed;

            double time=Math.sqrt(distanceY*distanceY+distanceX*distanceX)/(speed);
            if(unitLocation.unit.isDead())
            {
            }
            else{
            if(closestBuild.x>unitLocation.x)
            {
                unitLocation.unit.WalkingRight();
            }
            if(closestBuild.x<unitLocation.x)
            {
                unitLocation.unit.WalkingLeft();
                left=true;


            } else {
                left = false;
            }

                distanceY=-unitLocation.y+closestBuild.y+50;
                distanceX=-unitLocation.x+closestBuild.x-50;
                double totalDistance=(distanceX*distanceX)+(distanceY*distanceY);
                totalDistance=Math.sqrt(totalDistance);
                boolean stopAndAttack=false;
                if(totalDistance <=unitLocation.unit.range)
                {
                     stopAndAttack=true;
                }
                double range=unitLocation.unit.range;
                double rangeX=(distanceX/totalDistance)*range;
                double rangeY=(distanceY/totalDistance)*range;
                distanceY-=rangeY;
                distanceX-=rangeX;

            TranslateTransition translateTransition=new TranslateTransition();
            double travelTime=((totalDistance-range)/((double)speed));
            if(stopAndAttack==true)
                {
                    distanceY=0;
                    distanceX=0;
                    travelTime=0.001;
                }
            translateTransition.setDuration(Duration.seconds(travelTime));
            translateTransition.setNode(unitLocation.unit.currentPose);
            translateTransition.setByY(distanceY);
            translateTransition.setByX(distanceX);
            translateTransition.play();
            double finalDistanceY = distanceY;
            double finalDistanceX = distanceX;
            translateTransition.setOnFinished(event -> {
                if(!unitLocation.unit.isDead()){
                unitLocation.y=(int)(unitLocation.y+ finalDistanceY);
                unitLocation.x=(int)(unitLocation.x+ finalDistanceX);
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
                        if(unitLocation.unit.isDead())
                        {
                            timer.cancel();
                        }
                        unitLocation.unit.Attack(closestBuild);try {
                            if(closestBuild.destroyed())
                            {
                                Exception exception=new Exception();
                                throw exception;
                            }
                        } catch (Exception e) {
                            closestBuild.build.destroyed();
                            if(closestBuild.build instanceof Defence)
                            {
                                Destroy(closestBuild.x,closestBuild.y);
                            }
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
    }
    }
    public UnitThread(ArrayList<BuildLocation> buildLocations,UnitLocation unitLocation)
    {
        this.unitLocation=unitLocation;
        this.buildLocations=buildLocations;
    }
    public static void Destroy(int x,int y)
    {
        for(int i=0;i<Attack.defenceLocation.size();i++)
        {
            if(Attack.defenceLocation.get(i).x==x)
            {
                if(Attack.defenceLocation.get(i).y==y)
                {
                    Attack.defenceLocation.get(i).build.destroyed();
                    Attack.defenceLocation.get(i).build.hp=-10;
                    Attack.defenceLocation.remove(i);
                }
            }
        }
    }
}
