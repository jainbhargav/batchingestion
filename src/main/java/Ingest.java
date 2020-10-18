import com.fasterxml.jackson.databind.ObjectMapper;
import com.highspot.ingestion.model.Changes;
import com.highspot.ingestion.model.MixTape;
import com.highspot.ingestion.model.ModifyPlaylist;
import com.highspot.ingestion.model.Playlist;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* This class ingests the data from mixtape.json and changes.json which are passed as an argument to this class and are kept in resources folder.
Final data will be written to file named in 3rd argument.
 */
public class Ingest {

  private final static Logger LOGGER =
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

      static MixTape mixTape;
      public static void main(String args[])
      {
        //Ingest data from mixtape.json
        ingestMixtape(args[0]);

        //Ingest data from changes.json
        ingestChanges(args[1]);

        //Write ingested data to given file
        outputMixtape(args[2]);
      }




  public static void ingestMixtape(String filename)
      {
        LOGGER.log(Level.INFO, "Ingestion of mixtape file started");
        ObjectMapper mapper = new ObjectMapper();

        //Serialize data from file mixtape.json to Mixtape Objects
        try {
           mixTape = mapper.readValue(Ingest.class.getResourceAsStream(filename),MixTape.class);
        } catch (IOException e) {
          e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Ingestion of mixtape completed");
      }


  private static void ingestChanges(String filename) {

    LOGGER.log(Level.INFO, "Ingestion of changes file started");
    ObjectMapper mapper = new ObjectMapper();

    try {
      //Serialize data from file changes.json to Changes Objects
      Changes changes = mapper.readValue(Ingest.class.getResourceAsStream(filename),Changes.class);

      //Iterate addPlaylist object from changes file and add it to mixtape data
      for(Playlist playlist : changes.getAddPlaylists())
      {
        mixTape.getPlaylists().add(playlist);
      }

      //Iterate removePlaylist object from changes file and remove those playlists from mixtape data
      for(String id : changes.getRemovePlaylists())
      {
        mixTape.getPlaylists().remove(new Playlist(id));
      }

      //Retrieve playlists to be modified from changes file, get playlist object from mixtape data with id and add or remove songs
      for(ModifyPlaylist modifyPlaylists : changes.getModifyPlaylists())
      {

        mixTape.getPlaylists().stream().filter(playlist -> playlist.getId().equals(modifyPlaylists.getPlaylistId())).findFirst().orElse(null).getSong_ids().addAll(modifyPlaylists.getAddSong());
        mixTape.getPlaylists().stream().filter(playlist -> playlist.getId().equals(modifyPlaylists.getPlaylistId())).findFirst().orElse(null).getSong_ids().removeAll(modifyPlaylists.getRemoveSong());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    LOGGER.log(Level.INFO, "Ingestion of changes file completed");
  }

  public static void outputMixtape(String filename)
  {
    LOGGER.log(Level.INFO, "Output file construction started");
    ObjectMapper mapper = new ObjectMapper();
    //Deserialize the ingested data to file output.json
    try {
      mapper.writeValue(new File(filename), mixTape);
      LOGGER.log(Level.INFO, "Output file construction completed");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
