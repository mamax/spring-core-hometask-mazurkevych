package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService  {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao dao) {
        super();
        this.setDao(dao);
    }

    @Nullable
    @Override
    public Optional<User> getUserByEmail(@Nonnull String email) {
        return userDao.getUserByEmail(email);
    }

}
