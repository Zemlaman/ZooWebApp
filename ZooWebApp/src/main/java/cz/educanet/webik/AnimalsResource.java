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
    public Response createAnimal(
            @FormParam("id") int id,
            @FormParam("Name") String name,
            @FormParam("Age") int age,
            @FormParam("Weight") int weigth,
            @FormParam("Gender") String gender) {
        Animal animal = new Animal(id, name, age, weigth, gender);
        if (manager.animalCheck(id)) {
            return Response.ok("This animal already exists").build();
        } else {
            AnimalManager.animals.add(animal);
            return Response.ok("Animal:" + animal + "is added").build();
        }
    }

    @PUT
    @Path("{id}")
    public Response editAnimals(@PathParam("id") int id, Animal animal){
        if(manager.editAnimal(id, animal)){
            return Response.ok("Animal:" + "is changed").build();
        } else {
            return Response.ok("Something went wrong!").build();
        }

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
