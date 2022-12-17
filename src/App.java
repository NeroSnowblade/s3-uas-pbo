import Class.Player;
import Class.Monster;
import Class.Role;
import Class.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Scanner
    public static Scanner input = new Scanner(System.in);;
    
    // Method : Init Variable
    public static void initRole(Role[] role) {
        role[0] = new Role("Assassin", 6, 7, 4);
        role[1] = new Role("Warrior", 8, 4, 5);
        role[2] = new Role("Guardian", 5, 3, 9);
    }
    public static void initMonster(Monster[] monster) {
        monster[0] = new Monster("Bebelac", 10, 5);
        monster[1] = new Monster("Pampam", 10, 7);
        monster[2] = new Monster("Atan", 10, 9);
    }
    public static void initItem(ArrayList<String> item) {
        item.add("Kunci Emas");
        item.add("Koin");
        item.add("P3K");
    }
    public static void initInventory(Item[] inventory) {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item();
        }
    }
    
    // Method : Views
    public static int vIndex() {
        System.out.println("===== NIGHTSHADE =====");
        System.out.println("1. Mulai Permainan");
        System.out.println("2. Cara Bermain");
        System.out.println("3. Exit");
        System.out.print("Pilihanmu : ");
        int temp = input.nextInt();
        return temp;
    }
    public static void vCreatePlayer(Player player, Role[] role) {
        System.out.println("===== PLAYER CREATION ====");
        vPName(player);
        vPRole(role, player);
    }
    public static void vHowToPlay() {
        System.out.println("===== HOW TO PLAY =====");
        System.out.println("1. Player akan Spawn di Labirin N x N");
        System.out.println("2. Player diminta mencari Kunci Emas");
        System.out.println("3. Kunci Emas tersebut akan digunakan untuk membuka pintu keluar");
        System.out.println("4. Hati-hati Player mungkin bertemu Monster, lawan monster tersebut");
        System.out.println();
    }
    public static void vPName(Player player) {
        System.out.print("Masukan nama Player : ");
        String nama = input.next();
        player.setName(nama);
        System.out.println();
    }
    public static void vPRole(Role[] role, Player player) {
        boolean valid = false;
        do {
            System.out.println("SELECT ROLE");
            int count = 1;
            for (Role item : role) {
                System.out.println(count + ". " + item.getName() + "\t[STR: " + item.getStrength() + ", AGI: " + item.getAgility() + ", END: " + item.getEndurance() + "]");
                count++;
            }
            System.out.print("Pilihanmu : ");
            int iRole = input.nextInt();
            if(iRole <= role.length && iRole > 0) { 
                player.setRoleId(iRole); 
                valid = true; 
            }
            else { pInvalid(); }
        } while (!valid);
        System.out.println();
    }
    // Error
    public static void pInvalid() { System.out.println("\nInput tidak valid...\n"); }
    public static void main(String[] args) throws Exception {
        // Initialization
        Role[] role = new Role[3];
        initRole(role);
        Monster[] monster = new Monster[3];
        initMonster(monster);
        ArrayList<String> item = new ArrayList<String>();
        initItem(item);
        Item[] inventory = new Item[5];
        initInventory(inventory);
        Player player = new Player();
        
        int gInput = 0;
        try {
            do {
                gInput = vIndex();
                switch (gInput) {
                    case 1:
                    vCreatePlayer(player, role);
                    System.out.println(player.toString(role[player.getRoleId()], inventory, item));
                        break;
                    case 2:
                        vHowToPlay();
                        break;
                    case 3:
                        System.out.println("Mematikan permainan...");
                        break;
                    default:
                        pInvalid();
                        break;
                }
            } while(gInput != 3);
        } catch (Exception e) {
            System.out.println("Ada yang error nih..");
        }
    }
}