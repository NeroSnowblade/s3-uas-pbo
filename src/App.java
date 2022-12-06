import Class.Player;
import Class.Monster;
import Class.Role;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);
    
    public static void vRole(Role[] role) {
        System.out.println("SELECT ROLE");
        int count = 1;
        for (Role item : role) {
            System.out.println(count + ". " + item.getName() + "\t[STR: " + item.getStrength() + ", AGI: " + item.getAgility() + ", END: " + item.getEndurance() + "]");
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        Role[] role = new Role[3];
        role[0] = new Role("Assassin", 6, 7, 4);
        role[1] = new Role("Warrior", 8, 4, 5);
        role[2] = new Role("Tank", 5, 3, 9);

        Monster[] monster = new Monster[5];
        Player player = new Player("Mush", 100, 1);
        ArrayList<Integer> inventory = new ArrayList<Integer>();
        
        vRole(role);
    }
}