package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("animals")
public class AnimalsResource {
    @Inject
    private AnimalManager manager;

    public static List<Animal> animals = new ArrayList<Animal>();

    @GET
    public Response getAll() {
        return Response.ok(animals).build();
    }

    @POST
    @Path("create")
    public Response createAnimal(
            @FormParam("id") int id,
            @FormParam("Name") String name,
            @FormParam("Age") int age,
            @FormParam("Weight") int weigth,
            @FormParam("Gender") String gender
    ) {
        Animal animal = new Animal(id, name, age, weigth, gender);
        if (manager.animalCheck(animal)) {
            return Response.ok("This animal already exists").build();
        } else {
            animals.add(animal);
            return Response.ok("Animal:" + animal + "is added").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeAnimal(@PathParam("id") int id) {
        manager.animal = null;
        return Response.ok("Done").build();
    }

}
