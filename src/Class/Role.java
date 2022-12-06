package Class;

public class Role {
    private int agility, strength, endurance;
    private String name;
    
    public Role(){};
    public Role(String name, int strength, int agility, int endurance) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getEndurance() {
        return endurance;
    }
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
}
