package edu.upc.dsa;

import edu.upc.dsa.exceptions.ItemNotFoundException;
import edu.upc.dsa.models.Item;

import java.util.List;

public interface ItemsManager {
    public List<Item> findAll();
    public Item addItem(String nombre, String tipo, int daño, int armadura, String rareza, String descripcion, int precio);
    public Item addItem(Item i);
    public Item getItem(String id) throws ItemNotFoundException;
    public Item updateItem(Item i) throws ItemNotFoundException;
    public Item deleteItem(Item i) throws  ItemNotFoundException;
    public int size();
}
