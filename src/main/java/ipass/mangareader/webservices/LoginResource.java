package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;
import ipass.mangareader.security.AuthenticationResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Path("/login")
public class LoginResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") String username, @FormParam("password") String password){
        List response = new ArrayList();
        System.out.println(username + " " + password);
        List<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins) {
            if (admin.getName().equals(username) && admin.getPlainPassword().equals(password)){
                response.add(admin);
                AuthenticationResource tokenCreator = null;
                String token = tokenCreator.createToken(username, "admin");
                AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<>("JWT", token);
                response.add(JWT);
                System.out.println(JWT);
            }
        }
        return Response.ok(response).build();
    }
}
