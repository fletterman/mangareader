package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/manage")
public class ManageResource {
    @POST
    @Path("/{seriesID}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response serieDetail(@FormParam("title") String title, @FormParam("summary") String summary, @PathParam("seriesID") int seriesID) {
        ArrayList<Serie> allSeries = Serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                entry.setName(title);
                entry.setSummary(summary);
            }
            System.out.println(entry.getSeriesName());
            System.out.println(entry.getSeriesSummary());
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/{seriesID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSerie(@PathParam("seriesID") int serieID){
        if (Serie.deleteSerie(serieID)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{seriesID}/{chapterID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteChapter(@PathParam("seriesID") int seriesID, @PathParam("chapterID") int chapterID){
        if (Chapter.deleteChapter(seriesID, chapterID)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

