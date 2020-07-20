package ipass.mangareader.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import ipass.mangareader.domeinlaag.Admin;
import ipass.mangareader.webservices.AuthenticationResource;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        boolean isSecure = requestContext.getSecurityContext().isSecure();
        String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
        MysecurityContext msc = new MysecurityContext(null, scheme);
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring("Bearer".length()).trim();

            try {
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticationResource.key);
                Claims claims = parser.parseClaimsJws(token).getBody();

                String user = claims.getSubject();
                msc = new MysecurityContext(Admin.getUser(user),scheme);
            } catch (JwtException | IllegalArgumentException e){
                System.out.println("Invalid JWT, processing as guest");
            }
        }
        requestContext.setSecurityContext(msc);
    }
}
