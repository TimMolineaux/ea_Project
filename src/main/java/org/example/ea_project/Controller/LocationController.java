package org.example.ea_project.Controller;

import org.example.ea_project.Model.Location;
import org.example.ea_project.Model.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationDAO locationDAO;

    @Autowired
    public LocationController(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @GetMapping
    public Iterable<Location> getAllLocations() {
        return locationDAO.findAll();
    }

}
