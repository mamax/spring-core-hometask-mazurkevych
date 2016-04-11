package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Component
public class StaticUserDaoImpl implements UserDao {

    private static Map<Long, User> userMap = new HashMap<>();

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public User insert(User object) {
        userMap.put(object.getId(), object);
        return object;
    }

    @Nonnull
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userMap.values().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public User destroy(User object) {
        userMap.remove(object.getId(), object);
        return object;
    }

    @Override
    public Collection<User> findAll() {
        return userMap.values();
    }


}
