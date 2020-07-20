package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Path("/login")
public class LoginResource {
    @GET
    @Path("/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("username") String username, @PathParam("password") String password){
        ArrayList response = new ArrayList();
        List<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins) {
            if (admin.getName().equals(username) && admin.getPlainPassword().equals(password)){
                response.add(admin);
                AuthenticationResource tokenCreator = null;
                String token = tokenCreator.createToken(username, "admin");
                AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<>("JWT", token);
                response.add(JWT);
            }
        }
        return Response.ok(response).build();
    }
}
