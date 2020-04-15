package edu.upc.dsa.services;

import edu.upc.dsa.PlayersManager;
import edu.upc.dsa.PlayersManagerImpl;
import edu.upc.dsa.exceptions.PlayerNotFoundException;
import edu.upc.dsa.models.Player;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Api(value = "/players", description = "Endpoint to Player Service")
@Path("/players")

public class PlayerService {
    private PlayersManager pl;

    public PlayerService(){
        this.pl = PlayersManagerImpl.getInstance();
        if(pl.size() == 0) {
            this.pl.addPlayer("Jugador1", "1234");
            this.pl.addPlayer("Jugador2", "4321");
        }
    }
    @GET
    @ApiOperation(value = "get all players", notes = "todos los jugadores")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Player.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getPlayers(){
        List<Player> players = this.pl.findAll();
        GenericEntity<List<Player>> entity = new GenericEntity<List<Player>>(players){};
        return Response.status(201).entity(entity).build();
    }
    @GET
    @ApiOperation(value = "get a Player", notes = "un jugador especifico")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Player.class),
            @ApiResponse(code = 404, message = "Player not found")
    })
    @Path("/{user}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getPlayer(@PathParam("user") String user) throws PlayerNotFoundException {
        Player p = this.pl.getPlayer(user);
        if(p == null)
            throw new PlayerNotFoundException();
        else
            return Response.status(200).build();
    }
    @DELETE
    @ApiOperation(value = "delete a Player", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Player not found")
    })
    @Path("/{user}")
    public Response deletePlayer(@PathParam("user") String user) throws PlayerNotFoundException {
        Player p = this.pl.getPlayer(user);
        if (p == null)
            throw new PlayerNotFoundException();
        else {
            this.pl.deletePlayer(user);
            return Response.status(201).build();
        }
    }
    @PUT
    @ApiOperation(value = "update a Player", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Player not found")
    })
    @Path("/")
    public Response updatePlayer(Player uPlayer) throws PlayerNotFoundException {

        Player p = this.pl.updatePlayer(uPlayer);

        if (p == null) throw new PlayerNotFoundException();
        else
            return Response.status(201).build();
    }
    



}

