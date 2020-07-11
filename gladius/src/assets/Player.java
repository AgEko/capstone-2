package assets;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Item> inventory = new ArrayList<Item>();

    public Player(String name, List<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
