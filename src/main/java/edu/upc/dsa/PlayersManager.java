package edu.upc.dsa;

import edu.upc.dsa.exceptions.PlayerNotFoundException;
import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.Player;

import java.util.List;

public interface PlayersManager {

    public List<Player> findAll();
    public Player addPlayer(String user, String password);
    public Player addPlayer(Player p);
    public Player getPlayer(String user) throws PlayerNotFoundException;
    public Player deletePlayer(String user) throws PlayerNotFoundException;
    public Player updatePlayer(Player p) throws PlayerNotFoundException;

    public int size();

}
