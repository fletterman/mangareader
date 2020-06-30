package ipass.mangareader.webservices;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;

@Path("/chapter")
public class ChapterResource {
    String title;
    float chapterNumber;
    int serieID;

    @POST
    @Path("/addChapter/text/{seriesID}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addChapter(String jsonBody){
        StringReader stringReader = new StringReader(jsonBody);
        JsonStructure structure = Json.createReader(stringReader).read();
        if (structure.getValueType() == JsonValue.ValueType.OBJECT){
            JsonObject jsonObject = (JsonObject)structure;
            title = jsonObject.getString("title");
            chapterNumber = Float.parseFloat(jsonObject.getString("number"));
            serieID = Integer.parseInt(jsonObject.getString("serieID"));
            System.out.println(serieID);
        }
    }
}
