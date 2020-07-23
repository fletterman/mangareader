package ipass.mangareader.webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path("/manage")
public class ManageResource {
    @POST
    @Path("/cover/{seriesID}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(@FormParam("cover") InputStream inputStream, @PathParam("seriesID") String seriesID){


        return Response.ok().build();
    }
}
