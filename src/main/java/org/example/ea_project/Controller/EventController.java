package org.example.ea_project.Controller;

import jakarta.validation.Valid;
import org.example.ea_project.Model.Event;
import org.example.ea_project.Model.EventDAO;
import org.example.ea_project.Model.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EventController {

    private EventDAO eventDAO;
    private LocationDAO locationDAO;

    @Autowired
    public EventController(EventDAO eventDAO, LocationDAO locationDAO) {
        this.eventDAO = eventDAO;
        this.locationDAO = locationDAO;
    }

    @GetMapping({"", "/", "/index"})
    public String showEventList(ModelMap modelMap) {
        List<Event> latestEvents = eventDAO.findTop10ByOrderByIdDesc();
        modelMap.addAttribute("events", latestEvents);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(ModelMap modelMap) {
        modelMap.addAttribute("event", new Event());
        modelMap.addAttribute("locations", locationDAO.findAll());
        return "new";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/events/{id}")
    public String eventDetail(@PathVariable int id, ModelMap modelMap) {
        Optional<Event> event = eventDAO.findById(id);
        if (event.isPresent()) {
            modelMap.addAttribute("event", event.get());
            return "details";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/new")
    public String createEvent(@Valid @ModelAttribute("event") Event event,
                              BindingResult result,
                              ModelMap modelMap) {
        if (result.hasErrors()) {
            modelMap.addAttribute("locations", locationDAO.findAll());
            return "new";
        }

        eventDAO.save(event);
        return "redirect:/index";
    }

}
