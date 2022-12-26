import Class.Player;
import Class.Monster;
import Class.Role;
import Class.Item;
import Class.Maze;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class App {
    // Scanner
    public static Scanner input = new Scanner(System.in);
    public static Random random = new Random();

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
        item.add("Pisau");
    }
    public static void initInventory(Item[] inventory) {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item();
        }
    }
    public static void initMazeEasy(Maze[][] maze) {
        maze[0][0] = new Maze(false, true, true, false);
        maze[0][1] = new Maze(false, true, false, true);
        maze[0][2] = new Maze(false, true, true, true);
        maze[0][3] = new Maze(false, false, false, true, -5); // Monster

        maze[1][0] = new Maze(true, true, true, false); // Start
        maze[1][1] = new Maze(false, false, false, true, 3); // Pisau
        maze[1][2] = new Maze(true, false, true, false);
        maze[1][3] = new Maze(false, false, true, false, -10); // Finish

        maze[2][0] = new Maze(true, false, true, true);
        maze[2][1] = new Maze(false, true, false, false, 2); // P3K
        maze[2][2] = new Maze(true, true, true, true);
        maze[2][3] = new Maze(true, false, false, true);

        maze[3][0] = new Maze(true, false, false, false);
        maze[3][1] = new Maze(false, true, false, false, -5); // Monster
        maze[3][2] = new Maze(true, true, false, true);
        maze[3][3] = new Maze(false, false, false, true, 0); // Kunci
    }
    public static void initMazeHard(Maze[][] maze) {
        maze[0][0] = new Maze(false, false, true, false); // Start
        maze[0][1] = new Maze(false, true, true, false);
        maze[0][2] = new Maze(false, true, false, true);
        maze[0][3] = new Maze(false, true, false, true);
        maze[0][4] = new Maze(false, false, true, true);

        maze[1][0] = new Maze(true, true, false, false);
        maze[1][1] = new Maze(true, true, true, true);
        maze[1][2] = new Maze(false, false, false, true);
        maze[1][3] = new Maze(false, true, true, false);
        maze[1][4] = new Maze(true, false, false, true, 2); // P3K

        maze[2][0] = new Maze(false, true, false, false, -5); // Monster
        maze[2][1] = new Maze(true, false, true, true);
        maze[2][2] = new Maze(false, true, true, false, -5); // Monster
        maze[2][3] = new Maze(true, true, false, true);
        maze[2][4] = new Maze(false, false, true, true);

        maze[3][0] = new Maze(false, true, true, false);
        maze[3][1] = new Maze(true, true, false, true); // Weapon
        maze[3][2] = new Maze(true, true, true, true);
        maze[3][3] = new Maze(false, false, true, true);
        maze[3][4] = new Maze(true, false, false, false); // Weapon

        maze[4][0] = new Maze(true, true, false, false);
        maze[4][1] = new Maze(false, false, false, true, 0); // Kunci
        maze[4][2] = new Maze(true, false, false, false);
        maze[4][3] = new Maze(true, true, false, false);
        maze[4][4] = new Maze(false, false, false, true, -10); // Finish
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
        System.out.println();
        System.out.println("===== PLAYER CREATION ====");
        vPName(player);
        vPRole(role, player);
    }

    public static void vHowToPlay() {
        System.out.println();
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
        player.setHealth(100);
    }

    public static void vPRole(Role[] role, Player player) {
        boolean valid = false;
        do {
            System.out.println();
            System.out.println("SELECT ROLE");
            int count = 1;
            for (Role item : role) {
                System.out.println(count + ". " + item.getName() + "\t[STR: " + item.getStrength() + ", AGI: "
                        + item.getAgility() + ", END: " + item.getEndurance() + "]");
                count++;
            }
            System.out.print("Pilihanmu : ");
            int iRole = input.nextInt();
            if (iRole <= role.length && iRole > 0) {
                player.setRoleId(iRole);
                valid = true;
            } else {
                pInvalid();
            }
        } while (!valid);
        System.out.println();
    }

    public static int vSelectDifficulty() {
        System.out.println("===== SELECT DIFFICULTY =====");
        System.out.println("1. Easy (4x4)");
        System.out.println("2. Hard (5x5)");
        System.out.print("Pilihanmu : ");
        int temp = input.nextInt();
        return temp;
    }

    public static void vGame(Player player, Monster[] monster, Role[] role, Maze[][] maze, ArrayList<String> item, Item[] inventory, boolean finish, boolean death, String playerStatus, int iX, int iY) {
        player.setPos(iX, iY);
        do {
            int pX = player.getPosX(), pY = player.getPosY();

            int itemLantai = maze[pY][pX].getItemId();
            if (itemLantai > -1) {
                System.out.println("Kamu Menemukan " + item.get(itemLantai));
                boolean add = false;
                int i = 0;
                do {
                    if (inventory[i].getId() == -1 || inventory[i].getId() == itemLantai) {
                        if(inventory[i].getId() == -1) { inventory[i].setId(itemLantai); }
                        inventory[i].setQuantity(inventory[i].getQuantity() + 1);
                        maze[pY][pX].setItemId(-1);
                        add = true;
                    }
                    i++;
                    if (i == inventory.length) {
                        System.out.println("Inventory Penuh!");
                    }
                } while (!add && i < inventory.length);
            }

            if(itemLantai == -5){
                int randEnemy = random.nextInt(monster.length);
                Monster musuh = monster[randEnemy];
                int coin = musuh.getHealth();
                int mAttack = musuh.attack();
                System.out.println("Oh tidak kamu bertemu " + musuh.getName() + "!");
                do {
                    if(player.getHealth() < 0) {
                        death = true; 
                        return;
                    }
                    if(musuh.getHealth() < 0) {
                        if(inventory[4].getId() != 1) { inventory[4].setId(1); }
                        inventory[4].setQuantity(inventory[4].getQuantity() + coin);
                        return;
                    }
                    System.out.println("Player HP  : " + player.getHealth());
                    System.out.println(musuh.getName() + " HP : " + musuh.getHealth());
                    int randAct = random.nextInt(2);
                    if(randAct == 0) {System.out.println(musuh.getName() + " akan menyerang!");}
                    else {System.out.println(musuh.getName() + " nampaknya sedang beristirahat!");}
                    System.out.println("1. Attack");
                    System.out.println("2. Defend");
                    System.out.print("Pilihanmu : ");
                    int attOption = input.nextInt();
                    switch(attOption){
                        case 1:
                            if(randAct == 0) player.setHealth(player.getHealth() - mAttack);
                            musuh.setHealth(musuh.getHealth() - player.attack(role[player.getRoleId()]));
                            break;
                        case 2:
                            if(randAct == 0) player.setHealth(player.getHealth() + (player.defend(role[player.getRoleId()]) - mAttack));
                            break;
                        default:
                            pInvalid();
                            break;
                    }

                } while(musuh.getHealth() > 0 && player.getHealth() > 0);
                maze[pY][pX].setItemId(-1);
            }
            if(death) { return; }

            if (itemLantai == -10) {
                System.out.println("Kamu Menemukan Pintu Keluar Bergembok!");
                boolean isKey = false;
                for (Item i : inventory) {
                    if (i.getId() == 0) {
                        isKey = true;
                        break;
                    }
                }
                if (isKey) {
                    System.out.println("Kamu membuka gembok tersebut...");
                    finish = true;
                    break;
                } else {
                    System.out.println("Tetapi kamu belum memiliki Kuncinya");
                }
            }

            playerStatus = player.toString(role[player.getRoleId()], inventory, item);
            System.out.println("\n" + playerStatus + "\n");

            System.out.print("1. Atas ");
            if (player.getPosY() == 0 || !maze[pY][pX].isUp()) {
                System.out.println("[DINDING]");
            } else {
                System.out.println();
            }
            System.out.print("2. Kiri ");
            if (player.getPosX() == 0 || !maze[pY][pX].isLeft()) {
                System.out.println("[DINDING]");
            } else {
                System.out.println();
            }
            System.out.print("3. Kanan ");
            if (player.getPosX() == (maze.length - 1) || !maze[pY][pX].isRight()) {
                System.out.println("[DINDING]");
            } else {
                System.out.println();
            }
            System.out.print("4. Bawah ");
            if (player.getPosY() == (maze.length - 1) || !maze[pY][pX].isDown()) {
                System.out.println("[DINDING]");
            } else {
                System.out.println();
            }
            System.out.print("Pilihanmu : ");
            int move = input.nextInt();
            System.out.println();
            switch (move) {
                case 1:
                    if (player.getPosY() != 0 && maze[pY][pX].isUp()) {
                        player.setPosY(pY - 1);
                    } else {
                        System.out.println("Ini Dinding!");
                    }
                    break;
                case 2:
                    if (player.getPosX() != 0 && maze[pY][pX].isLeft()) {
                        player.setPosX(pX - 1);
                    } else {
                        System.out.println("Ini Dinding!");
                    }
                    break;
                case 3:
                    if (player.getPosX() != (maze.length - 1) && maze[pY][pX].isRight()) {
                        player.setPosX(pX + 1);
                    } else {
                        System.out.println("Ini Dinding!");
                    }
                    break;
                case 4:
                    if (player.getPosY() != (maze.length - 1) && maze[pY][pX].isDown()) {
                        player.setPosY(pY + 1);
                    } else {
                        System.out.println("Ini Dinding!");
                    }
                    break;
                default:
                    break;
            }
        } while (!finish && !death);

        if (finish)
            System.out.println("Selamat kamu berhasil keluar dari Labirin!\n");
        if (death)
            System.out.println("Oh tidak kamu tewas!\n");
    }

    // Method : Print
    public static void pInvalid() {
        System.out.println("\nInput tidak valid...\n");
    }

    public static void pExit() {
        System.out.println("\nMematikan Permainan...\n");
    }

    public static void main(String[] args) throws Exception {
        // Initialization
        Role[] role = new Role[3];
        initRole(role);
        Monster[] monster = new Monster[3];
        initMonster(monster);
        ArrayList<String> item = new ArrayList<String>();
        initItem(item);
        Item[] inventory = new Item[5];
        Maze[][] mazeEasy = new Maze[4][4];
        initMazeEasy(mazeEasy);
        Maze[][] mazeHard = new Maze[5][5];
        initMazeHard(mazeHard);
        Player player = new Player();
        int gInput = 0;
        try {
            do {
                gInput = vIndex();
                switch (gInput) {
                    case 1:
                        vCreatePlayer(player, role);
                        initInventory(inventory);
                        String playerStatus = player.toString(role[player.getRoleId()], inventory, item);
                        int difficulty = vSelectDifficulty();
                        boolean finish = false, death = false;
                        if (difficulty == 1) {
                            vGame(player, monster, role, mazeEasy, item, inventory, finish, death, playerStatus, 0, 1);
                        } else if (difficulty == 2) {
                            vGame(player, monster, role, mazeHard, item, inventory, finish, death, playerStatus, 0, 0);
                        }
                        break;
                    case 2:
                        vHowToPlay();
                        break;
                    case 3:
                        pExit();
                        break;
                    default:
                        pInvalid();
                        break;
                }
            } while (gInput != 3);
        } catch (Exception e) {
            System.out.println("Ada yang error nih..");
        }
    }
}