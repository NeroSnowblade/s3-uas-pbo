package Class;
import Interface.Combat;

public class Monster extends Entity implements Combat {
    int attack = 0;
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
    public void atack() {
        
    }

    @Override
    public void defend() {
        
    }


}
