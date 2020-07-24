package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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

    @GET
    @Path("/{seriesID}/{chapterID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChapter(@PathParam("seriesID") int seriesID, @PathParam("chapterID") int chapterID){
        ArrayList allImages = new ArrayList();
        System.out.println("test");

        ArrayList<Serie> allSeries = Serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                TreeMap<String, Chapter> allChapters = entry.getAllChapters();
                for (Map.Entry<String, Chapter> eachChapter : allChapters.entrySet()) {
                    System.out.println(eachChapter.getValue().getChapterID());
                    if (eachChapter.getValue().getChapterID() == chapterID) {
                        System.out.println(eachChapter.getValue().hasPrevious());
                        allImages.add(eachChapter.getValue().giveName());
                        allImages.add(eachChapter.getValue().giveNumber());
                    }
                }
            }
        }

        return Response.ok(allImages).build();
    }
}
