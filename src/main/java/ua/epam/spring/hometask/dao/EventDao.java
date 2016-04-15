package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
public interface EventDao extends AbstractDomainObjectService<Event> {

    Event getByName(String name);

}
