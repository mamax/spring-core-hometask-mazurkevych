package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;

import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
public interface EventDao extends AbstractDomainObjectService<Event> {

    Optional<Event> getByName(String name);

}
