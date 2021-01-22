package cz.educanet.webik;
import cz.educanet.webik.Animal;
import cz.educanet.webik.AnimalManager;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("caretakers")
public class CaretakerResource {

    @Inject
    private CaretakerManager manager;

    @GET
    @Path("{id}")
    public Response getCaretaker(@PathParam("id") int id){
        return Response.ok(manager.getCaretaker(id)).build();
    }

    @GET
    public Response getAll() {
        return Response.ok(manager.getAllCaretakers()).build();
    }

    @POST
    @Path("create")
    public Response createCaretaker(
            @FormParam("id") int id,
            @FormParam("FirstName") String firstName,
            @FormParam("LastName") String lastName,
            @FormParam("gender") String gender) {
        Caretaker caretaker = new Caretaker(id, firstName, lastName, gender);
        if(manager.caretakerCheck(id)){
            return Response.ok("This caretaker already exists").build();
        } else {
            manager.caretakers.add(caretaker);
            return Response.ok("Caretaker:" + caretaker + "is added").build();
        }
    }

    @PUT
    @Path("{id}")
    public Response editCareTaker(@PathParam("id") int id, Caretaker careTaker){
        if(manager.editCaretaker(id, careTaker)){
            return Response.ok("Ok").build();
        } else {
            return Response.ok("Something went wrong!").build();
        }
    }


    @DELETE
    @Path("{id}")
    public Response removeCaretaker(@PathParam("id") int id) {
        if(manager.deleteCaretaker(id)){
            return Response.ok("Cartaker removed").build();
        } else {
            return Response.ok("Something went wrong!").build();
        }

    }
}
