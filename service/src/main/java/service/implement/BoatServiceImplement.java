package service.implement;

import Boatshop.exceptions.DateException;
import Boatshop.exceptions.NoMatchingException;
import Boatshop.models.Boat;
import DAO.BoatDAO;
import services.BoatService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class BoatServiceImplement implements BoatService {
    private BoatDAO dao;

    public BoatServiceImplement(BoatDAO dao) {
        this.dao = dao;
    }

    public Collection<Boat> getAllBoat() throws NoMatchingException {
        return dao.readAllBoat();
    }

    public Boat getBoat(UUID id) throws NoMatchingException {
        return null;
    }

    public void addBoat(Boat boat) throws DateException, NoMatchingException {
    if(Boat.getGyartasiev().isAfter(LocalDate.now())){
        throw new DateException();}
    dao.createBoat(boat);
    }

    public void updateBoat(Boat boat) throws NoMatchingException, DateException {
        if(Boat.getGyartasiev().isAfter(LocalDate.now())){
            throw new DateException();}
        dao.updateBoat(boat);
    }

    public void deleteBoat(Boat boat) throws NoMatchingException {
        dao.deleteBoat(boat);
    }
}
