package stationery.store.bundle.user;


import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import stationery.store.bundle.abstractAndInterfaces.CrudService;
import stationery.store.exceptions.EmailExistsException;

import java.util.Set;

public interface UserService<T extends User> extends CrudService<T, Long> {

    T updateExistingUser(T user) throws EmailExistsException;

    T getUserByEmail(String email);

}
