package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    @Nullable
    @Override
    public User getUserByEmail(String email) {
        for(User user:userMap.values()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
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
