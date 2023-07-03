package Data.AttackData;

import Data.unit.Unit;
import Data.unit.Units;

public class InHandUnit {
    private int total;
    private int wizard;
    private int knight;
    private int archer;
    private int enchantress;

    public int getArcher() {
        return archer;
    }

    public int getEnchantress() {
        return enchantress;
    }

    public int getKnight() {
        return knight;
    }

    public int getTotal() {
        return total;
    }

    public int getWizard() {
        return wizard;
    }

    public InHandUnit(int wizard, int knight, int archer, int enchantress) {
        this.total=0;
        this.archer = archer;
        this.knight = knight;
        this.wizard = wizard;
        this.enchantress = enchantress;
        total = enchantress + wizard + knight + archer;
    }
    public boolean finished()
    {
        int total=archer+wizard+enchantress+knight;
        if(total==0)
        {
            return true;
        }
        return false;
    }
    public Unit get(int id) {
        if (id == 1) {
            if (knight > 0) {
                knight--;
                total--;
                return Units.getByID(id);
            }
        }
        if (id == 2) {
            if (enchantress > 0) {
                enchantress--;
                total--;
                return Units.getByID(id);
            }
        }
        if (id == 3) {
            if (archer > 0) {
                archer--;
                total--;
                return Units.getByID(id);
            }
        }
        if (id == 4) {
            if (wizard > 0) {
                wizard--;
                total--;
                return Units.getByID(id);
            }
        }
        return null;
    }
    public boolean haveUnit(int id)
    {
        if(id==1)
        {
            if(knight==0)
                return false;
        }
        if(id==2)
        {
            if(enchantress==0)
                return false;
        }
        if(id==3)
        {
            if(archer==0)
                return false;
        }
        if(id==4)
        {
            if(wizard==0)
                return false;
        }
        return true;
    }

}
