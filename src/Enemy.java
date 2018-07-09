abstract class Enemy {
    boolean isAlive;
    int health;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth(Enemy enemy) { return this.health; }

}
