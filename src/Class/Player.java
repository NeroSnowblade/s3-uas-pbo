package Class;
import Interface.Combat;

public class Player extends Entity implements Combat {
    private int roleId;

    public Player() {};
    public Player(String name, int health, int roleId) {
        super(name, health);
        this.roleId = roleId;
    }
    
    public int getRoleId() {
        return roleId - 1;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public void hurt() {
        System.out.println("Ugh..");
    }

    @Override
    public void atack() {
        
    }
    @Override
    public void defend() {
        
    }
}
