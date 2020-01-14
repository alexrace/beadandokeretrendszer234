package DAO;

import Boatshop.exceptions.NoMatchingException;
import Boatshop.models.Boat;

import java.util.Collection;

public interface BoatDAO {
    void createBoat(Boat boat) throws NoMatchingException;
    Collection<Boat> readAllBoat()throws NoMatchingException;
    void updateBoat(Boat boat)throws NoMatchingException;
    void deleteBoat(Boat boat)throws NoMatchingException;
}
