package stationary.store.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stationary.store.model.*;
import stationary.store.service.address.AddressService;
import stationary.store.service.cartItem.CartItemService;
import stationary.store.service.cart.CartService;
import stationary.store.service.category.CategoryService;
import stationary.store.service.product.ProductService;
import stationary.store.service.user.UserService;
import stationary.store.utilities.exceptions.NotFoundException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AppRestController {

    // autowire the UserService
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/product/bestseller")
    public List<Product> getBestSellers(@RequestParam int limit) {

        if(limit<1){
            throw new NotFoundException("Limit should be > 0 - your limit = " + limit);
        }

        List<Product> products = productService.getBestSellers(limit);

        return products;
    }

    @GetMapping("/category")
    public List<Category> getCategoriesWithLimit(@RequestParam(required = false) int limit) {

//        if(limit<1){
//            throw new NotFoundException("Limit should be > 0 - your limit = " + limit);
//        }

        List<Category> categories = categoryService.getCategories(limit);

        return categories;
    }

//    @GetMapping("/category")
//    public List<Category> getCategories() {
//
//        List<Category> categories = categoryService.getCategories();
//
//        return categories;
//    }




    // add mapping for GET /users
    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }




}
	

	

















