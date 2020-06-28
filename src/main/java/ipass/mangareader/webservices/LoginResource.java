package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/login")
public class LoginResource {
    @GET
    @Path("/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("username") String username, @PathParam("password") String password){
        ArrayList response = new ArrayList();
        ArrayList<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins) {
            if (admin.giveName().equals(username) && admin.givePassword().equals(password)){
                response.add(admin);
            }
        }
        return Response.ok(response).build();
    }
}
