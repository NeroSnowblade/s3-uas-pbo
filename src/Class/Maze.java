package Class;

public class Maze {
    private int itemId = -1;
    private boolean left = false, right = false, up = false, down = false;
    
    public Maze(boolean up, boolean right, boolean down, boolean left) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
    }
    public Maze(boolean up, boolean right, boolean down, boolean left, int itemId) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public boolean isDown() {
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public boolean isRight() {
        return right;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
}
