package edu.upc.dsa.models;


import java.util.ArrayList;
import java.util.List;

public class Player {
    String username;
    String password;
    int level;
    int currentLive;
    int maxLive;
    List<Item> OwnerItems;

    public Player(String user, String password)
    {
        setUsername(user);
        setPassword(password);
        this.level = 1;
        this.maxLive = 100;
    }
    /*Gets*/
    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public int getLevel() {return this.level;}
    public int getCurrentLive() {return this.currentLive;}
    public int getMaxLive() {return this.maxLive;}
    public List<Item> ItemsList(){return this.OwnerItems;}
    /*Sets*/
    public void setUsername(String user){this.username = user;}
    public void setLevel(int level) {this.level = level;}
    public void setCurrentLive(int c_live) {this.currentLive = c_live;}
    public void setMaxLive(int m_live) {this.maxLive = m_live;}
    public void setOwnerItems(List<Item> it){OwnerItems = it;}
    public void setPassword(String password) {this.password = password;}
}