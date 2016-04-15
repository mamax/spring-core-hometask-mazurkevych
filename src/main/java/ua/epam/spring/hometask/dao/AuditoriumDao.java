package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
public interface AuditoriumDao {

    Set<Auditorium> getAll();

    Auditorium getByName(String name);
}
