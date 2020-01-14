package services;

import Boatshop.exceptions.DateException;
import Boatshop.exceptions.NoMatchingException;
import Boatshop.models.Boat;

import java.util.Collection;
import java.util.UUID;

public interface BoatService {
    Collection<Boat> getAllBoat() throws NoMatchingException;
    Boat getBoat(UUID id) throws NoMatchingException;
    void addBoat(Boat boat) throws DateException, NoMatchingException;
    void updateBoat(Boat boat) throws  NoMatchingException,DateException;
    void deleteBoat(Boat boat) throws NoMatchingException;
}
