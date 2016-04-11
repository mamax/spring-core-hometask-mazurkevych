package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * @author Maksym_Mazurkevych
 */
public interface UserService extends AbstractDomainObjectService<User> {

    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserByEmail(@Nonnull String email);

    /**
     * Finding user by Id
     *
     * @param id
     *          Id of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getById(@Nonnull Long id);

    /**
     * Getting all users from the system
     *
     * @param users object of class User
     *
     * @return set of users
     */
    public @Nullable Set<User> getAll(User users);

    /**
     * Saves user
     */
    public void save();

    /**
     * Removes user
     */
    public void remove();

}
