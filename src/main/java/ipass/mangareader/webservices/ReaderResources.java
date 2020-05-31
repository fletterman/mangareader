package ipass.mangareader.webservices;

import ipass.mangareader.domeinlaag.Chapter;
import ipass.mangareader.domeinlaag.Page;
import ipass.mangareader.domeinlaag.Series;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Path("/reader")
public class ReaderResources {

    @GET
    @Path("/{seriesID}/{chapterNumber}")
    @Produces(MediaType.TEXT_HTML)
    public Response getChapter(@PathParam("seriesID") int seriesID, @PathParam("chapterNumber") int chapterNumber){
        Series series = null;

        new Series("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            Page pageAdd = new Page(id, id+1, 0, 1);
            id += 1;
        }
        new Series("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 15, 0, 0);
        for (int i = 0; i < 27; i++) {
            new Page(i+28, i+1, 1, 0);
        }

        new Series("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 4, 2, 2);
        for (int i = 0; i < 26; i++) {
            new Page(i+53, i+1, 2, 2);
        }
        ArrayList allImages = new ArrayList();

        TreeMap<Integer, Series> allSeries = series.giveAllSeries();
        for (Map.Entry<Integer, Series> entry : allSeries.entrySet()) {
            series = entry.getValue();
            int seriesKey = entry.getKey();
            if(seriesKey==seriesID){
                ArrayList<Chapter> allChapters = series.getAllChapters();
                for (Chapter eachChapter : allChapters){
                    if(eachChapter.giveNumber() == chapterNumber){
                        ArrayList<String> allpages = eachChapter.getPages();
                        System.out.println(allpages);
                        for (int i = 0; i < allpages.size(); i++) {
                            allImages.add(allpages.get(i));
                        }
                    }
                }
            }
        }
//        System.out.println(allImages);
//        System.out.println("Testing");
//        return allImages;
        return Response.ok(allImages).build();
    }
}
