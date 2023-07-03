package Data.build;

import Data.AttackData.UnitLocation;

public interface Defence {
    public void Attack(UnitLocation unitLocation);
    public boolean InRange(UnitLocation unitLocation);
    public boolean isBusy();
}
