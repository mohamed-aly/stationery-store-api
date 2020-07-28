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


    @GetMapping("/all")
    public Set<User> getCustomers(){
        return userService.findByUserType(UserType.CUSTOMER);
    }

    @PostMapping("/signUp")
    public User signUp(@RequestBody User user) throws EmailExistsException {
        return userService.save(user, UserType.CUSTOMER);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PatchMapping("/update")
    public User updateCustomer(@RequestBody User user) throws EmailExistsException {
        User updatedCustomer = userService.updateExistingUser(user);
        updatedCustomer.setPassword(null);
        return updatedCustomer;
    }


}
	

	

















