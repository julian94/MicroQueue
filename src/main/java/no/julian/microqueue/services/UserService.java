package no.julian.microqueue.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import no.julian.microqueue.util.*;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("user")
public class UserService {
    @PersistenceContext
    EntityManager em;

    /*
        ToDo: Add auth check.
        ToDo: make sure the users only change themselves.
        ToDo: prevent SQL injection!!!!
     */

    @GET
    public List<User> getAllUsers(){
        User user = new User();
        return (List<User>) em.createQuery("select u from User u", user.getClass()).getResultList();
    }

    /**
     *
     * @param id The username of the desired user.
     * @return The users username, name, and in the future picture.
     */
    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") String id){
        User user = new User();
        List<User> userList = (List<User>) em.createQuery("select u from User u where u.id ='"+ id + "'", user.getClass()).getResultList();
        if (userList.size() != 1) return null; // Todo: return something more appropiate.
        return userList.get(0);
    }

    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public User patchUser(@PathParam("id") String id, User user){
        // ToDo: update the username locally.
        return user;
    }

    @DELETE
    @Path("{id}")
    public User deleteUser(@PathParam("id") String id){
        // ToDo: delete user.
        User user = new User();
        return user;
    }
}
