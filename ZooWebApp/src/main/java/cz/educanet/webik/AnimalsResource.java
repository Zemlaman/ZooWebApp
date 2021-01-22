package cz.educanet.webik;
import cz.educanet.webik.Animal;
import cz.educanet.webik.AnimalManager;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("animals")
public class AnimalsResource {

    @Inject
    private AnimalManager manager;


    @GET
    @Path("{id}")
    public Response getAnimal(@PathParam("id") int id){
        return Response.ok(manager.getAnimal(id)).build();
    }

    @GET
    public Response getAll() {
        return Response.ok(manager.getAllAnimals()).build();
    }

    @POST
    @Path("create")
    public Response createAnimal(Animal animal) {
        manager.addNewAnimal(animal);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response removeAnimal(@PathParam("id") int id) {
        if(manager.deleteAnimal(id)){
            return Response.ok("Animal removed").build();
        } else {
            return Response.ok("Something went wrong!").build();
        }

    }

}
