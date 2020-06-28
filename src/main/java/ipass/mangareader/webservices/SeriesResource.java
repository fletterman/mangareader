package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/series")
public class SeriesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSeries(){
        ArrayList allSeries = Serie.giveAllSeries();
        return Response.ok(allSeries).build();
    }

    @GET
    @Path("/{seriesID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSerie(@PathParam("seriesID") int seriesID){
        Serie serie = Serie.getSeries(seriesID);
        return Response.ok(serie).build();
    }
}
