package edu.upc.dsa;

import edu.upc.dsa.exceptions.ItemNotFoundException;
import edu.upc.dsa.exceptions.PlayerNotFoundException;
import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.Player;

import java.util.List;

public class ItemsManagerImpl implements ItemsManager {

    protected List<Item> itemList;

    @Override
    public Item addItem(Item i) {
        this.itemList.add(i);
        return i;
    }

    @Override
    public Item addItem(String nombre, String tipo, int daño, int armadura, String rareza, String descripcion, int precio) {
        return this.addItem(new Item(nombre,tipo,daño,armadura,rareza,descripcion,precio));
    }

    @Override
    public Item getItem(String id) throws ItemNotFoundException {
        boolean encontrado = false;
        Item foundItem = null;
        for (Item i: this.itemList) {
            if (i.getId().equals(id)) {
                encontrado = true;
                foundItem = i;
            }
        }
        if(encontrado == true)
            return foundItem;
        else
            throw new ItemNotFoundException();
    }

    @Override
    public List<Item> findAll() {return this.itemList;}

    @Override
    public Item updateItem(Item i) throws ItemNotFoundException {
        Item updateItem = this.getItem(i.getId());
        if(updateItem != null)
        {
            updateItem.setNombre(i.getNombre());
            updateItem.setTipo(i.getTipo());
            updateItem.setDaño(i.getDaño());
            updateItem.setArmadura(i.getArmadura());
            updateItem.setRareza(i.getRareza());
            updateItem.setDescripcion(i.getDescripcion());
            updateItem.setPrecio(i.getPrecio());
            return updateItem;
        }
        else
            throw new ItemNotFoundException();
    }

    @Override
    public Item deleteItem(Item i) throws ItemNotFoundException {
        Item deleteItem = this.getItem(i.getId());
        if(deleteItem == null)
            throw new ItemNotFoundException();
        else
        {
            this.itemList.remove(deleteItem);
            return null;
        }
    }

    @Override
    public int size() {return this.itemList.size();}
}
