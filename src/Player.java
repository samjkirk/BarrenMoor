public class Player extends GameLoop {
    private String name;
    private String weapon;
    private int health;
    private double distanceFromOriginNorth;
    private double distanceFromOriginSouth;
    private double distanceFromOriginEast;
    private double distanceFromOriginWest;

    public Player (String name, String weapon, int health, double north, double south, double east, double west) {
        setName(name);
        setWeapon(weapon);
        setHealth(health);
        setDistanceFromOriginNorth(north);
        setDistanceFromOriginSouth(south);
        setDistanceFromOriginEast(east);
        setDistanceFromOriginWest(west);
    }

    public String toString(Player player){
        System.out.println();
        return  "Name: " + player.getName(player) +
                "\nWeapon: " + player.getWeapon(player) +
                "\nHealth: " + player.getHealth(player) +
                "\nDistance from Origin" +
                "\nN:" + player.getDistanceFromOriginNorth(player) +
                "\nS:" + player.getDistanceFromOriginSouth(player) +
                "\nE:" + player.getDistanceFromOriginEast(player) +
                "\nW:" + player.getDistanceFromOriginWest(player) +
                "\n";
    }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setWeapon(String weapon) { this.weapon = weapon; }
    public void setHealth(int health) { this.health = health; }
    public void setDistanceFromOriginNorth(double north) { this.distanceFromOriginNorth = north; }
    public void setDistanceFromOriginSouth(double south) { this.distanceFromOriginSouth = south; }
    public void setDistanceFromOriginEast(double east) { this.distanceFromOriginEast = east; }
    public void setDistanceFromOriginWest(double west) { this.distanceFromOriginWest = west; }

    // Getters
    public String getName(Player player) { return this.name; }
    public String getWeapon(Player player) { return this.weapon; }
    public int getHealth(Player player) { return this.health; }
    public double getDistanceFromOriginNorth(Player player) { return this.distanceFromOriginNorth; }
    public double getDistanceFromOriginSouth(Player player) { return this.distanceFromOriginSouth; }
    public double getDistanceFromOriginEast(Player player) { return this.distanceFromOriginEast; }
    public double getDistanceFromOriginWest(Player player) { return this.distanceFromOriginWest; }
}
