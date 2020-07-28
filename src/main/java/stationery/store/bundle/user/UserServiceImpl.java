package stationery.store.bundle.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationery.store.bundle.abstractAndInterfaces.CrudService;
import stationery.store.bundle.customer.Customer;
import stationery.store.bundle.customer.CustomerDAO;
import stationery.store.exceptions.EmailExistsException;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Set<User> findAll() {
        log.debug("I'm in the service");

        Set<User> userSet = new HashSet<>();
        userDAO.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }

    @Override
    public Set<User> findByUserType(UserType userType) {
        return userDAO.findByType(userType.getType());
    }


    @Override
    public void deleteById(Long idToDelete) {
        userDAO.deleteById(idToDelete);
    }


    private boolean emailExist(final String email) {
        final User user = userDAO.findByEmail(email);
        return user != null;
    }

    @Override
    public User save(final User user, UserType userType) throws EmailExistsException {
        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserType(userType);
        return userDAO.save(user);
    }

    @Override
    public User save(User object) throws EmailExistsException {
        return userDAO.save(object);
    }

    @Override
    public User updateExistingUser(User user) throws EmailExistsException {
        if (!emailExist(user.getEmail())) {
            throw new EmailExistsException("There is no account with that email address: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }


    @Override
    public User findById(Long l) {
        return null;
    }


    @Override
    public void delete(User object) {

    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }


}





