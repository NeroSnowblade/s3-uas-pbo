package Class;
import java.util.ArrayList;

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

    public String toString(Role role, Item[] inventory, ArrayList<String> allItem) {
        String listItem = "";
        for (Item i : inventory) {
            if(i.getId() != -1) { listItem += i.getQuantity() + "x " + allItem.get(i.getId()) + ","; }
        }
        if(listItem == "") { listItem = "Kosong"; }
        

        return  "Nama\t: " + this.name + 
                "\nHealth\t: " + this.health + 
                "\nRole\t: " + role.getName() +
                "\nItem\t: " + listItem;
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
