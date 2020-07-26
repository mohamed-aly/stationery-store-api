package stationery.store.bundle.user;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import stationery.store.exceptions.EmailExistsException;

import java.util.Set;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService<User> userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Set<User> getUsers(){
        return userService.findAll();
    }
}
	

	

















