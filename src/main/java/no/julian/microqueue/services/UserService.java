package no.julian.microqueue.services;

import javax.ws.rs.*;
import no.julian.microqueue.util.*;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("user")
public class UserService {

    /**
     *
     * @param id The username of the desired user.
     * @return The users username, name, and in the future picture.
     */
    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") String id){
        User user = new User();
        user.setId(id);
        user.setName("Test.");
        return user;
    }

    @GET
    public String test(){
        return "success";
    }
}
