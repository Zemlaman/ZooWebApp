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

    public static List<Caretaker> caretakers = new ArrayList<Caretaker>();

    @GET
    public Response getAll() {
        return Response.ok(caretakers).build();
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
        if(caretakerCheck(caretaker)){
            return Response.ok("This caretaker already exists").build();
        } else {
            caretakers.add(caretaker);
            return Response.ok("Caretaker:" + caretaker + "is added").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeCareTaker(@PathParam("id") int id) {
        manager.caretaker = null;
        return Response.ok("Done").build();
    }

    public Boolean caretakerCheck(Caretaker caretaker) {
        for (int i = 0; i < caretakers.size(); i++) {
            if (caretakers.get(i).getFirstName().equals(caretaker.getFirstName())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
