package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Component
public class StaticEventDaoImpl implements EventDao {

    private static Map<Long, Event> eventMap = new HashMap<>();

    @Nullable
    @Override
    public Optional<Event> getByName(String name) {
        return eventMap.values().stream().filter(u -> u.getName().equals(name)).findFirst();
    }

    @Override
    public Event save(Event object) {
         eventMap.put(object.getId(), object);
        return object;
    }

    @Override
    public void remove(Event object) {
        eventMap.remove(object.getId(), object);
    }

    @Override
    public Event getById(Long id) {
        return eventMap.get(id);
    }

    @Override
    public Collection<Event> findAll() {
        return eventMap.values();
    }
}
