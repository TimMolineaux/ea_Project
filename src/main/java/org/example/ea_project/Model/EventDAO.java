package org.example.ea_project.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventDAO extends CrudRepository<Event, Integer> {
    List<Event> findTop10ByOrderByIdDesc();
}
