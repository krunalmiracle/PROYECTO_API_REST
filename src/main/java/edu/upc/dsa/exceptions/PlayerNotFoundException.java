package edu.upc.dsa.exceptions;

import javax.ws.rs.core.Response;

public class PlayerNotFoundException extends Exception{
    public Response PlayerNotFoundException(){
        return Response.status(404).build();
    }
}
