package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;

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
    public User save(User object) {
        userMap.put(object.getId(), object);
        return object;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userMap.values().stream()
                .filter(u -> u.getEmail().equals(email)).findFirst();
    }

    @Override
    public void remove(User object) {
        userMap.remove(object.getId(), object);
    }

    @Override
    public Collection<User> getAll() {
        return userMap.values();
    }

}
