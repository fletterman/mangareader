package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
                TreeMap<String, Chapter> allChapters = entry.getAllChapters();
                for (Map.Entry<String, Chapter> eachChapter : allChapters.entrySet()){
                    if(eachChapter.getValue().giveNumber() == chapterNumber){
                        allImages.add(eachChapter.getValue().giveName());
                        allImages.add(eachChapter.getValue().giveNumber());
                        ArrayList<String> allpages = eachChapter.getValue().getPages();
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
