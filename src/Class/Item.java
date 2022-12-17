package Class;

public class Item {
    int id = -1, quantity;
    
    public Item() {}
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
