package Class;
import java.util.ArrayList;

import Interface.Combat;

public class Player extends Entity implements Combat {
    private int roleId;
    private int posX, posY;

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
    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public String toString(Role role, Item[] inventory, ArrayList<String> allItem) {
        String listItem = "";
        for (Item i : inventory) {
            if(i.getId() != -1) { listItem += i.getQuantity() + "x " + allItem.get(i.getId()) + ", "; }
        }
        if(listItem == "") { listItem = "Kosong"; }
        

        return  "Nama\t: " + this.getName() + 
                "\nHealth\t: " + this.getHealth() + 
                "\nRole\t: " + role.getName() +
                "\nPosition: [Z : " + this.getPosX() + " ] [Y : " + this.getPosY() + " ]" +
                "\nItem\t: " + listItem;
    }

    @Override
    public void hurt() {
        System.out.println("Ugh..");
    }
    
    @Override
    public int attack() {
        return 5;
    }
    @Override
    public int defend() {
        return 0;
    }

    public int attack(Role role) {
        return role.getStrength();
    }
    public int defend(Role role) {
        return role.getEndurance();
    }

}
