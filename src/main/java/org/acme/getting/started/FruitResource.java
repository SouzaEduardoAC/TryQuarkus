package org.acme.getting.started;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit")
public class FruitResource {

    FruitRepository fruitRepository;
    public FruitResource(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> fruits(@QueryParam("season") String season) {
        if (season != null)
            return fruitRepository.findBySeason(season);
            // return Fruit.findBySeason(season); Active Repository Pattern
        return Fruit.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFruit(Fruit fruit) {
        fruit.id = null;
        fruit.persist();
        return Response.status(Response.Status.CREATED).entity(fruit).build();
    }
}
