package no.julian.microqueue.services;

import no.julian.microqueue.util.Queue;
import no.julian.microqueue.util.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("queue")
public class QueueService {
    @PersistenceContext
    EntityManager em;

    /*
        ToDo: Add auth check.
        ToDo: make sure the users only change themselves.
        ToDo: prevent SQL injection!!!!
     */

    @GET
    public List<Queue> getAllQueues(){
        Queue queue = new Queue();
        return (List<Queue>) em.createQuery("select q from Queue q", queue.getClass()).getResultList();
    }

    /**
     *
     * @param id The username of the desired user.
     * @return The users username, name, and in the future picture.
     */
    @GET
    @Path("{id}")
    public Queue getQueue(@PathParam("id") String id){
        Queue queue = new Queue();
        List<Queue> queueList = (List<Queue>) em.createQuery("select q from Queue q where q.id ='"+ id + "'", queue.getClass()).getResultList();
        if (queueList.size() != 1) return null; // Todo: return something more appropiate.
        return queueList.get(0);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Queue newQueue(Queue queue){
        em.persist(queue); // Todo: make sure this gets a proper id before returning to user.
        return queue;
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Queue patchQueue(Queue queue){
        em.persist(queue);
        return queue;
    }

    @DELETE
    @Path("{id}")
    public void deleteQueue(@PathParam("id") String id){
        // ToDo: delete queue
    }
}
