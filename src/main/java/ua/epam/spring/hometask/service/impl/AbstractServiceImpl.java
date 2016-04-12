package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Maksym_Mazurkevych on 4/12/2016.
 */
public abstract class AbstractServiceImpl<T extends DomainObject> implements AbstractDomainObjectService<T> {

    protected AbstractDomainObjectService<T> dao;

    public void setDao(AbstractDomainObjectService<T> dao) {
        this.dao = dao;
    }

    @Override
    @Nullable
    public T getById(@Nonnull Long id) {
        return dao.getById(id);
    }

    @Override
    @Nonnull
    public Collection<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T save(@Nonnull T object) {
        return dao.save(object);
    }

    @Override
    public void remove(@Nonnull T object) {
        dao.remove(object);
    }

}
