package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
public interface UserDao {

    User getById(Long id);

    User insert(User object);

    Optional<User> getUserByEmail(String email);

    User destroy(User object);

    Collection<User> findAll();
}
