package ipass.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public abstract class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("ipass.mangareader.webservices, ipass.mangareader.security");
        register(RolesAllowedDynamicFeature.class);
    }
}
