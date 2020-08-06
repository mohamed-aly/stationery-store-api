package stationery.store.bundle.user;


import stationery.store.bundle.abstractAndInterfaces.CrudService;
import stationery.store.exceptions.EmailExistsException;

import java.util.Set;

public interface UserService extends CrudService<User, Long> {

    User saveWithEncryption(final User user, UserType userType) throws EmailExistsException;

    User getUserByEmail(String email);

    Set<User> findByUserType(UserType userType);

}
