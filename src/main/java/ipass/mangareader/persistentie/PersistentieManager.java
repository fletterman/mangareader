package ipass.mangareader.persistentie;
import ipass.mangareader.domeinlaag.*;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

import java.io.*;

public class PersistentieManager {
    private final static String ENDPOINT = "https://fletterman.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=bfqt&srt=co&sp=rwdlacupx&se=2020-07-31T20:24:36Z&st=2020-07-20T12:24:36Z&spr=https,http&sig=NhEl9FMhMPEhHjW3ZPf6e5iBqUNQLCZwBJMknO7518o%3D";
    private final static String CONTAINER = "fletterman";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void saveSerieToAzure() throws IOException {
        if (!blobContainer.exists()){
            blobContainer.create();
            System.out.println("Blobcontainer created");
        }

        BlobClient blob = blobContainer.getBlobClient("series");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Serie.giveAllSeries());

        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        blob.upload(bais, bytes.length, true);

        oos.close();
        bais.close();
    }

    public static void loadSerieFromAzure() throws IOException, ClassNotFoundException {
        System.out.println("Test");
        if (blobContainer.exists()){
            System.out.println("Container exists");
            BlobClient blob = blobContainer.getBlobClient("series");

            if (blob.exists()){
                System.out.println("Blob exists");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                byte[] bytes = baos.toByteArray();

                ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object obj = ois.readObject();
                if (obj instanceof Serie){
                    Serie loadSerie = (Serie)obj;
                    System.out.println(loadSerie);
                    Serie.setSerie(loadSerie);
                }

                baos.close();
                ois.close();
            } else {
                System.out.println("Blob doesn't exist");
            }
        }
    }
}
