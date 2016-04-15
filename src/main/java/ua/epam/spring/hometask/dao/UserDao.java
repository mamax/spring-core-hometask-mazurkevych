package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
public interface UserDao extends AbstractDomainObjectService<User> {

    User getUserByEmail(String email);

}
