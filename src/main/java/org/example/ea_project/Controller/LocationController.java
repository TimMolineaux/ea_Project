package org.example.ea_project.Controller;

import org.example.ea_project.Model.Location;
import org.example.ea_project.Model.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable int id) {
        Optional<Location> location = locationDAO.findById(id);
        return location.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationDAO.save(location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id) {
        if (locationDAO.existsById(id)) {
            locationDAO.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
