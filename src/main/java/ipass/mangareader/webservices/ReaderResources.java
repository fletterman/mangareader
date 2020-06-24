package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/reader")
public class ReaderResources {

    @GET
    @Path("/{seriesID}/{chapterNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChapter(@PathParam("seriesID") int seriesID, @PathParam("chapterNumber") int chapterNumber){
        Serie serie = null;

        ArrayList allImages = new ArrayList();

        ArrayList<Serie> allSeries = serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if(seriesKey==seriesID){
                ArrayList<Chapter> allChapters = entry.getAllChapters();
                for (Chapter eachChapter : allChapters){
                    if(eachChapter.giveNumber() == chapterNumber){
                        allImages.add(eachChapter.giveName());
                        allImages.add(eachChapter.giveNumber());
                        ArrayList<String> allpages = eachChapter.getPages();
                        for (String allpage : allpages) {
                            allImages.add(allpage);
                        }
                    }
                }
            }
        }
        return Response.ok(allImages).build();
    }
}
