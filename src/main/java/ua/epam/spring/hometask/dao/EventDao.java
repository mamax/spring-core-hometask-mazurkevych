package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
public interface EventDao {

    Optional<Event> getByName(String name);

    Event save(Event object);

    void remove(Event object);

    Event getById(Long id);

    Collection<Event> findAll();
}
