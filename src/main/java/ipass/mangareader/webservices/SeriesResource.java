package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
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

    @PUT
    @Path("/{seriesID}")
//    @Consumes(MediaType.)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setCover (@PathParam("seriesID") int seriesID){
        Serie serie = Serie.getSeries(seriesID);
        //set new cover
        File newCover = null;
        boolean set = serie.setCover(newCover);
        String response;
        if (set){
            response = "succes";
        }
        else {
            response = "failure";
        }
        return Response.ok(response).build();
    }
}
