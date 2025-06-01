package org.example.ea_project.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Gelieve een titel in te vullen!")
    @Size(max = 30, message = "Titel mag max. 30 karakters bevatten!")
    private String title;

    @NotBlank(message = "Gelieve een beschrijving in te vullen!")
    @Size(max = 500, message = "Beschrijving mag max. 500 tekens bevatten!")
    private String description;

    @NotNull(message = "Gelieve een tijdstip in te vullen!")
    @Future(message = "Het ingegeven tijdstip moet in de toekomst liggen!")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @NotBlank(message = "Gelieve de naam van de organiseur in te vullen!")
    @Size(max = 30, message = "Naam mag max. 30 karakters bevatten!")
    private String organizer;

    @NotBlank(message = "Gelieve een contactmail in te vullen!")
    @Email(message = "Gelieve een gelgig email in te vullen!")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Event() {}

    public Event(int id, String title, String description, LocalDateTime date, String organizer, String contact, Location location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.organizer = organizer;
        this.contact = contact;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
