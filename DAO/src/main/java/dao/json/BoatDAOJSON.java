package dao.json;

import Boatshop.exceptions.NoMatchingException;
import Boatshop.models.Boat;
import DAO.BoatDAO;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class BoatDAOJSON  implements BoatDAO {
        File jsonfile;
        ObjectMapper mapper;

    public BoatDAOJSON(String jsonFilePath){
        this.jsonfile=new File(jsonFilePath);
        if(!jsonfile.exists())
        {
            try{
                jsonfile.createNewFile();
                FileWriter writer=new FileWriter(jsonFilePath);
                writer.write("[]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
    }

    public BoatDAOJSON(File jsonfile) {
        this.jsonfile = jsonfile;
        if(!jsonfile.exists())
        {
            try{
                jsonfile.createNewFile();
                FileWriter writer=new FileWriter(jsonfile);
                writer.write("[]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
    }

    public void createBoat(Boat boat) throws NoMatchingException {
        Collection<Boat> boats = readAllBoat();
        boats.add(boat);
        try
        {
            mapper.writeValue(jsonfile,boats);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<Boat> readAllBoat() throws NoMatchingException {
        Collection<Boat> boats=new ArrayList<Boat>();
        try{
            boats= mapper.readValue(jsonfile, new TypeReference<Collection<Boat>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boats;
    }

    public void updateBoat(Boat boat) throws NoMatchingException {
        Boat DeleteThis= new Boat();
        DeleteThis.setId(boat.getId());
        deleteBoat(DeleteThis);
        createBoat(boat);
    }

    public void deleteBoat(Boat boat) throws NoMatchingException {
    Collection<Boat> boats=readAllBoat();
    try{

        mapper.writeValue(jsonfile,boats);
    } catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
