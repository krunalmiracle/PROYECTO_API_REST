package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Item {
    String id;
    String nombre;
    String tipo;
    int daño;
    int armadura;
    String rareza;
    String descripcion;
    int precio;

    public Item(String nombre1, String tipo1, int daño1, int armadura1, String rareza1, String descripcion1, int precio1)
    {
        this.id = RandomUtils.getId();
        setNombre(nombre1);
        setTipo(tipo1);
        setDaño(daño1);
        setArmadura(armadura1);
        setRareza(rareza1);
        setDescripcion(descripcion1);
        setPrecio(precio1);
    }

    /*Gets*/
    public String getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getTipo(){return this.tipo;}
    public int getDaño(){return this.daño;}
    public int getArmadura(){return this.armadura;}
    public String getRareza(){return this.rareza;}
    public String getDescripcion(){return this.descripcion;}
    public int getPrecio(){return this.precio;}

    /*Sets*/
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setDaño(int daño){this.daño = daño;}
    public void setArmadura(int armadura){this.armadura = armadura;}
    public void setRareza(String rareza){this.rareza = rareza;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    public void setPrecio(int precio){this.precio = precio;}
}
