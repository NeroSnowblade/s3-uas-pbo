package Class;
import Interface.Combat;

public class Monster extends Entity implements Combat {
    private int attack = 0;
    public Monster() {};
    public Monster(String name, int health) {
        super(name, health);
    }
    public Monster(String name, int health, int attack) {
        super(name, health);
        this.attack = attack;
    }

    @Override
    public void hurt() {
        System.out.println("Graaahh..");
    }

    @Override
    public int attack() {
        return this.attack;
    }

    @Override
    public int defend() {
        return 0;
    }


}
