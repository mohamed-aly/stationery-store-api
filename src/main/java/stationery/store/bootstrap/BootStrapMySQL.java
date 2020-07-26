package stationery.store.bootstrap;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import stationery.store.bundle.user.User;
import stationery.store.bundle.user.UserDAO;
import stationery.store.bundle.user.UserService;


/**
 * Created by jt on 8/7/17.
 */
@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private UserDAO userDAO;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public BootStrapMySQL(UserDAO userDAO, UserService userService, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @SneakyThrows
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (userDAO.count() == 0) {

            User user = new User();
            user.setFirstName("Test");
            user.setLastName("Test");
            user.setPassword(passwordEncoder.encode("test"));
            user.setEmail("test@test.com");
            user.setEnabled(true);
            userDAO.save(user);
        }
    }

}
