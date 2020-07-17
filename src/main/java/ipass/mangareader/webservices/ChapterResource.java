package ipass.mangareader.webservices;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("/chapter")
public class ChapterResource {
    String title;
    float chapterNumber;
    int serieID;

    @POST
    @Path("/addChapter/text/{seriesID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addChapter(String jsonBody){
        String message = "succes";
        StringReader stringReader = new StringReader(jsonBody);
        JsonStructure structure = Json.createReader(stringReader).read();
        if (structure.getValueType() == JsonValue.ValueType.OBJECT){
            JsonObject jsonObject = (JsonObject)structure;
            title = jsonObject.getString("title");
            if (title.length() == 0){
                message = "No title added";
                return Response.ok(message).build();
            }
            chapterNumber = Float.parseFloat(jsonObject.getString("number"));
            if (chapterNumber >= 0){
                message = "No chapternumber added";
                return Response.ok(message).build();
            }
            serieID = Integer.parseInt(jsonObject.getString("serieID"));
            if (serieID >= 0){
                message = "No serieID was given";
                return  Response.ok(message).build();
            }
            System.out.println(serieID);
        }
        return Response.ok(message).build();
    }
}
