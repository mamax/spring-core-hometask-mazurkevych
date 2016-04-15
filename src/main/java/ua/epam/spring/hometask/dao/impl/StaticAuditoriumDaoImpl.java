package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Component
public class StaticAuditoriumDaoImpl implements AuditoriumDao {

    private static Map<Auditorium, List<User>> auditoriumMap = new HashMap<>();

    @Override
    public Set<Auditorium> getAll() {
        return auditoriumMap.keySet();
    }

    @Override
    public Auditorium getByName(String name) {
        for(Auditorium auditorium:auditoriumMap.keySet()){
            if (auditorium.getName().equals(name)){
                return auditorium;
            }
        }
        return null;
    }
}
