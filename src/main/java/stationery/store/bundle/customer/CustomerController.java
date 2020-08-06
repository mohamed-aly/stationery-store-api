package stationery.store.bundle.customer;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import stationery.store.bundle.user.User;
import stationery.store.bundle.user.UserService;
import stationery.store.bundle.user.UserType;
import stationery.store.exceptions.EmailExistsException;

import java.util.Set;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    private final UserService userService;

    public CustomerController(UserService userService) {
        this.userService = userService;
    }


}
	

	

















