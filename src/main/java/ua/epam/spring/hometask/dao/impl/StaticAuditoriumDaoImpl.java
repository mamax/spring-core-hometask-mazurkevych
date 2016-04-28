package ua.epam.spring.hometask.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.conf.AuditoriumConfiguration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Component
public class StaticAuditoriumDaoImpl implements AuditoriumDao {

    private static Set<Auditorium> auditoriumSet = new HashSet<>();

    @Autowired
    private AuditoriumConfiguration auditoriumConfiguration;

    @Override
    public Set<Auditorium> getAll() {
        return new HashSet(auditoriumConfiguration.auditoriumsList());
    }

    @Override
    public Auditorium getByName(String name) {
        for(Auditorium auditorium:auditoriumSet){
            if (auditorium.getName().equals(name)){
                return auditorium;
            }
        }
        return null;
    }
}
