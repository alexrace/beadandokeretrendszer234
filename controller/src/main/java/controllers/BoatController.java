package controllers;

import Boatshop.exceptions.DateException;
import Boatshop.exceptions.NoMatchingException;
import Boatshop.models.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.BoatService;

import java.util.Collection;

@RestController
public class BoatController {
    private BoatService service;

    public BoatController(@Autowired BoatService service) {
        this.service = service;
    }
    @RequestMapping(value="/listAllBoat",method= RequestMethod.GET)
    @ResponseBody
    public String showBoatCount() throws NoMatchingException {
        return String.valueOf(service.getAllBoat().size());
    }
    @RequestMapping(value="/Boats",method= RequestMethod.GET)

    @ResponseBody
    public Collection<Boat> getAllBoat() throws NoMatchingException {
        return service.getAllBoat();
    }
    @RequestMapping(value = "/addBoat",method = RequestMethod.POST)
    @ResponseBody
    public Boat addBoat(@RequestBody Boat boat) throws NoMatchingException, DateException {
        service.addBoat(boat);
        return  service.getBoat(boat.getId());
    }

}
