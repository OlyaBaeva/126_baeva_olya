package task;

public class ArmorDestroyer extends BattleUnitBase {
    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int maxArmor = -1;
        BattleUnit wake = null;
        for (int i = 0; i < enemyTeam.length; i++) {
            if ((enemyTeam[i].health() > 0) && (enemyTeam[i].maxArmor() > maxArmor)) {
                maxArmor = enemyTeam[i].maxArmor();
                wake = enemyTeam[i];
            }
        }
        if (wake.armor() > 0) wake.damageArmor(strength() * 2);
        else wake.takeDamage(strength() / 4);
    }

    public void attack(BattleUnit other) {
        if (other.armor() > 0) {
            other.damageArmor(strength());
            if (strength() / 4 > 0) other.takeDamage(strength() / 4);
            else other.takeDamage(1);
        } else {
            if (strength() / 2 > 0) other.takeDamage(strength() / 2);
            else other.takeDamage(1);
        }
    }
}