package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Component
public class StaticAuditoriumDaoImpl implements AuditoriumDao {

    private static Map<Auditorium, String> auditoriumMap = new HashMap<>();

    @Override
    public Set<Auditorium> getAll() {
        return auditoriumMap.keySet();
    }

    @Override
    public Optional<Auditorium> getByName(String name) {
        return auditoriumMap.keySet().stream().filter(u -> u.getName().equals(name)).findFirst();
    }
}
