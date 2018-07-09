public class Troll extends Enemy {
    public String weapon;

    public Troll (boolean isAlive, int health, String weapon) {
        setWeapon(weapon);
        setAlive(isAlive);
        setHealth(health);
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
