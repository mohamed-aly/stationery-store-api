package stationery.store.bundle.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationery.store.exceptions.EmailExistsException;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@Service
@Transactional
public class UserServiceImpl<T extends User> implements UserService<T> {

    private final UserDAO<T> userDAO;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Set<T> findAll() {
        log.debug("I'm in the service");

        Set<T> userSet = new HashSet<>();
        userDAO.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }


    @Override
    public void deleteById(Long idToDelete) {
        userDAO.deleteById(idToDelete);
    }



    private boolean emailExist(final String email) {
        final T user = userDAO.findByEmail(email);
        return user != null;
    }

    @Override
    public T save(final T insertedUser) throws EmailExistsException {
        if (emailExist(insertedUser.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + insertedUser.getEmail());
        }

        insertedUser.setPassword(passwordEncoder.encode(insertedUser.getPassword()));
        return userDAO.save(insertedUser);
    }

    @Override
    public T updateExistingUser(T user) throws EmailExistsException {
        if (!emailExist(user.getEmail())) {
            throw new EmailExistsException("There is no account with that email address: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public T findById(Long l) {
        return null;
    }


    @Override
    public void delete(T object) {

    }

    @Override
    public T getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }


}





