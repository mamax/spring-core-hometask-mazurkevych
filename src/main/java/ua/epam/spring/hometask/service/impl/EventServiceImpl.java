package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Service
public class EventServiceImpl extends AbstractServiceImpl<Event> implements EventService {

    @Autowired
    private EventDao eventDao;

    public EventServiceImpl() {
        super();
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDao.getByName(name);
    }

}
