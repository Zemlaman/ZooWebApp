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
    public Response getCartaker(@PathParam("id") int id){
        return Response.ok(manager.getCartaker(id)).build();
    }

    @GET
    public Response getAll() {
        return Response.ok(manager.getAllCartakers()).build();
    }

    @POST
    @Path("create")
    public Response createAnimal(Caretaker caretaker) {
        manager.addNewCartaker(caretaker);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response removeCartaker(@PathParam("id") int id) {
        if(manager.deleteCartaker(id)){
            return Response.ok("Cartaker removed").build();
        } else {
            return Response.ok("Something went wrong!").build();
        }

    }
}
