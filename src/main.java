import java.util.*;

public class main{

public class Player {
    private int HP;
    private int maxHP;
    private int xp;
    private int atk;
    private int def;
    private int lvl;

    private int numPotions;

    public Player() {
        HP = maxHP;
        lvl = 1;
        def = 1;
        atk = 1;
        numPotions = 1;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hp) {
        HP = hp;
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public void heal() {
        if (numPotions > 0) {
            numPotions--;
            HP = maxHP;
        }
    }


}
}
