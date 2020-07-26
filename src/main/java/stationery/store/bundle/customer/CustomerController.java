package stationery.store.bundle.customer;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import stationery.store.bundle.user.UserService;
import stationery.store.exceptions.EmailExistsException;

import java.util.Set;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    private final UserService<Customer> userService;


    public CustomerController(UserService<Customer> userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Set<Customer> getCustomers(){
        return userService.findAll();
    }

    @PostMapping("/save")
    Customer newCustomer(@RequestBody Customer customer) throws EmailExistsException {
        return userService.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PatchMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) throws EmailExistsException {
        Customer updatedCustomer = userService.updateExistingUser(customer);
        updatedCustomer.setPassword(null);
        return updatedCustomer;
    }


}
	

	

















