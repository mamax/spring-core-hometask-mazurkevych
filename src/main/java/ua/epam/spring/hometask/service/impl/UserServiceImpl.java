package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Nullable
    @Override
    public Optional<User> getUserByEmail(@Nonnull String email) {
        return userDao.getUserByEmail(email);
    }

    @Nullable
    @Override
    public User getById(@Nonnull Long id) {
        return userDao.getById(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User save(@Nonnull User object) {
        return userDao.insert(object);
    }

    @Override
    public void remove(@Nonnull User object) {
        userDao.destroy(object);
    }

}
