package no.julian.microqueue.services;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.*;

import no.julian.microqueue.DatasourceProducer;
import no.julian.microqueue.util.*;

import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("auth")
public class AuthService {
    @PersistenceContext
    EntityManager em;

    @Resource(lookup = DatasourceProducer.JNDI_NAME)
    DataSource dataSource;

    /**
     * @param credentials The username and password of the desired user.
     * @return A bearer token and a copy of that users profile.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("login")
    public LoginResult login(LoginCredentials credentials){
        System.out.println("login");
        User user = new User();
        user.setId(credentials.getId());
        user.setName("Julian Silden Langlo");
        String token = "bananaphone";
        LoginResult result = new LoginResult(user, token);
        return result;
    }

    /**
     * @param credentials The username and password of the desired user.
     * @return A bearer token and a copy of that users profile.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("register")
    public LoginResult register(LoginCredentials credentials){


        List<User> userList = (List<User>) em.createQuery("select u from User u where u.id ='"+ credentials.getId() + "'").getResultList();

        if (userList.isEmpty()) {
            return new LoginResult(false);
        }

        User user = new User();
        user.setId(credentials.getId());
        user.setName("Julian Silden Langlo");

        em.persist(user);

        String token = "bananaphone";
        LoginResult result = new LoginResult(user, token);
        System.out.println(em.merge(user));
        return result;
    }
}
