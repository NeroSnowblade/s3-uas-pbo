package Class;
import Interface.Combat;

public class Monster extends Entity implements Combat {

    public Monster() {};
    public Monster(String name, int health) {
        super(name, health);
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
