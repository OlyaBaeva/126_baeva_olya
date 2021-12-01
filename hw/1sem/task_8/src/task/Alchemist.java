package task;

public class Alchemist extends BattleUnitBase {
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int hp=1000000000;
        int hp1=0;
        BattleUnit dead = null;
        BattleUnit wake = null;
        for (int i = 0; i<ownTeam.length;i++) {
            if ((ownTeam[i].health() < hp) && (ownTeam[i].health() > 0)) {
                hp = ownTeam[i].health();
                dead = ownTeam[i];
            }
            if ((ownTeam[i].health() > hp1)&&(ownTeam[i].health()>0)) {
                hp1 = ownTeam[i].health();
                wake = ownTeam[i];
            }
        }
            dead.heal(10);
            wake.setStrength(wake.strength()+1);
    }

    public void attack(BattleUnit other){
    other.setStrength(other.strength()-2);
    other.setMaxHealth(other.maxHealth()-4);
    }
}