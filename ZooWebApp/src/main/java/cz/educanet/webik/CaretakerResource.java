package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("caretakers")
public class CaretakerResource {

    @Inject
    private CaretakerManager manager;

    @GET
    public Response getAll() {
        return Response.ok(manager.caretakers).build();
    }

    @GET
    @Path("{id}")
    public Response getDetail(@PathParam("id") int id) {
        return Response.ok(manager.getCaretaker(id)).build();
    }

    @POST
    @Path("create")
    public Response createTaker(
            @FormParam("id") int id,
            @FormParam("FirstName") String firstName,
            @FormParam("LastName") String lastName,
            @FormParam("gender") String gender
    ) {
        Caretaker caretaker = new Caretaker(id, firstName, lastName, gender);
        if(manager.caretakerCheck(caretaker)){
            return Response.ok("This caretaker already exists").build();
        } else {
            manager.caretakers.add(caretaker);
            return Response.ok("Caretaker:" + caretaker + "is added").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response removeCareTaker(@PathParam("id") int id) {
        manager.caretaker = null;
        return Response.ok("Done").build();
    }

}
