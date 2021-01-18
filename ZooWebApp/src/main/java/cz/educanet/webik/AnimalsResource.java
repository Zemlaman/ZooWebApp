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

    public static List<Animal> animal = new ArrayList<Animal>();

    @GET
    public Response getAll() {
        return Response.ok(animal).build();
    }

    @POST
    @Path("register")
    public Response createAnimal(
            @FormParam("id") int id,
            @FormParam("Name") String name,
            @FormParam("Age") int age,
            @FormParam("Weight") int weigth,
            @FormParam("Gender") String gender
    ) {
        Animal animal = new Animal(id, name, age, weigth, gender);
        if(animalCheck(animal)){
            return Response.ok("This animal already exists").build();
        } else {
            animal.add(animal);
            return Response.ok("Animal:" + animal + "is added").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response editCareTaker(@PathParam("id") int id, Caretaker careTaker) {

        if(manager.editAnimal(id, careTaker)){
            return Response.ok("Animal edited").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    @DELETE
    @Path("/{id}")
    public Response removeAnimal(@PathParam("id") int id) {
        manager.animal = null;
        return Response.ok("Done").build();
    }

    public Boolean animalCheck(Animal animal) {
        for (int i = 0; i < animal.size(); i++) {
            if (animal.get(i).getName().equals(animal.getName())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
