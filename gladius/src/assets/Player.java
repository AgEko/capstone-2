package assets;

import assets.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Item> inventory;

    public Player() {
        this.inventory = new ArrayList<Item>();
    }


    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
