package stationary.store.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stationary.store.model.Address;
import stationary.store.model.Cart;
import stationary.store.model.CartItem;
import stationary.store.model.User;
import stationary.store.service.address.AddressService;
import stationary.store.service.cartItem.CartItemService;
import stationary.store.service.cart.CartService;
import stationary.store.service.user.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserRestController {

    // autowire the UserService
    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartService carService;

    @Autowired
    private CartItemService carItemService;

    // add mapping for GET /users
    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User user = userService.getUser(userId);

        if (user == null) {
            throw new NotFoundException("Customer id not found - " + userId);
        }

        return user;
    }

    @GetMapping("/addresses")
    public List<Address> getAddresses() {

        return addressService.getAddresses();

    }

    @GetMapping("/carts")
    public List<Cart> getCarts() {

        return carService.getCarts();

    }

    @GetMapping("/cartItems")
    public List<CartItem> getCartItems() {

        return carItemService.getCartItems();

    }

}
	

	

















