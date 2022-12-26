package Class;

public class Item {
    private int id, quantity;
    
    public Item() {
        this.id = -1;
    }
    public Item(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
