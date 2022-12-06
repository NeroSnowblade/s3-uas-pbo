package Class;

abstract class Entity {
    String name;
    int health;

    Entity() {}
    Entity(String name, int health) {
        this.name = name;
        this.health = health;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    
    public abstract void hurt();
}
