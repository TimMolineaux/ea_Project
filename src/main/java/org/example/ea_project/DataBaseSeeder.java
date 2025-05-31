package org.example.ea_project;

import org.example.ea_project.Model.Location;
import org.example.ea_project.Model.LocationDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseSeeder {

    @Bean
    CommandLineRunner initDatabase(LocationDAO locationDAO) {
        return args -> {
            if (locationDAO.count() == 0) {
                locationDAO.save(new Location(0, "Gemeenschapscentrum A", "Voorbeeldstraat 1, 1070 Anderlecht", 50));
                locationDAO.save(new Location(0, "Zaal B", "Anderlechtplein 5, 1070 Anderlecht", 80));
                locationDAO.save(new Location(0, "Bibliotheek Zuid", "Zuidlaan 10, 1070 Anderlecht", 30));
            }
        };
    }
}
