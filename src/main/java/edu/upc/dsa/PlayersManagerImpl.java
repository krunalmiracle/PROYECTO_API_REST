package edu.upc.dsa;

import edu.upc.dsa.exceptions.PlayerNotFoundException;
import edu.upc.dsa.models.Item;
import edu.upc.dsa.models.Player;
import edu.upc.dsa.models.Track;

import java.util.LinkedList;
import java.util.List;

public class PlayersManagerImpl implements PlayersManager {
    private static PlayersManager instance;
    protected List<Player> playerList;

    private PlayersManagerImpl(){this.playerList = new LinkedList<>();}

    public static PlayersManager getInstance() {
        if (instance==null) instance = new PlayersManagerImpl();
        return instance;
    }

    @Override
    public Player addPlayer(Player p) {
        this.playerList.add(p);
        return p;
    }

    @Override
    public Player addPlayer(String user, String password) {
        return this.addPlayer(new Player(user, password));
    }

    @Override
    public Player getPlayer(String user) throws PlayerNotFoundException {
        boolean encontrado = false;
        Player foundPlayer = null;
        for (Player p: this.playerList) {
            if (p.getUsername().equals(user)) {
                encontrado = true;
                foundPlayer = p;
            }
        }
        if(encontrado == true)
            return foundPlayer;
        else
            throw new PlayerNotFoundException();

    }

    @Override
    public List<Player> findAll() {return this.playerList;}

    @Override
    public Player updatePlayer(Player p) throws PlayerNotFoundException {
        Player UpdatedPlayer = this.getPlayer(p.getUsername());
        if(UpdatedPlayer != null)
        {
            UpdatedPlayer.setUsername(p.getUsername());
            UpdatedPlayer.setPassword(p.getPassword());
            UpdatedPlayer.setLevel(p.getLevel());
            UpdatedPlayer.setMaxLive(p.getMaxLive());
            UpdatedPlayer.setOwnerItems(p.ItemsList());
            return UpdatedPlayer;
        }
        else
            throw new PlayerNotFoundException();
    }

    @Override
    public Player deletePlayer(String user) throws PlayerNotFoundException {
        Player deletedPlayer = this.getPlayer(user);
        if(deletedPlayer == null)
            throw new PlayerNotFoundException();
        else {
            this.playerList.remove(deletedPlayer);
            return null;
        }
    }

    @Override
    public int size() {
        return this.playerList.size();
    }
}

