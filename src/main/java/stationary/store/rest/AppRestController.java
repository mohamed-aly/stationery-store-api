package stationary.store.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stationary.store.model.*;
import stationary.store.service.address.AddressService;
import stationary.store.service.cartItem.CartItemService;
import stationary.store.service.cart.CartService;
import stationary.store.service.grade.GradeService;
import stationary.store.service.gradeLevel.GradeLevelService;
import stationary.store.service.offer.OfferService;
import stationary.store.service.product.ProductService;
import stationary.store.service.productImage.ProductImageService;
import stationary.store.service.user.UserService;
import stationary.store.utilities.exceptions.NotFoundException;
import stationary.store.utilities.json.GradeJSON;
import stationary.store.utilities.json.GradeLevelJSON;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AppRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartService carService;

    @Autowired
    private CartItemService carItemService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private GradeLevelService gradeLevelService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImagesService;


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


    @GetMapping("/grade/levels")
    public List<GradeLevelJSON> getGradeLevels() {
        List<GradeLevel> gradeLevels = gradeLevelService.getGradeLevels();

        List<GradeLevelJSON> gradeLevelJSONS = new ArrayList<>();
        for (int i = 0; i < gradeLevels.size(); i++) {
            GradeLevelJSON gradeLevelJSON = new GradeLevelJSON(gradeLevels.get(i).getId() , gradeLevels.get(i).getLevel());
            gradeLevelJSONS.add(gradeLevelJSON);
        }

        return gradeLevelJSONS;
    }


    @GetMapping("/grade/level/{id}")
    public List<GradeJSON> getGradeLevel(@PathVariable int id) {
        GradeLevel gradeLevel = gradeLevelService.getGradeLevel(id);

        if (gradeLevel == null) {
            throw new NotFoundException("GradeLevel id not found - " + id);
        }

        List<GradeJSON> gradeJSONS = new ArrayList<>();

//        for (int i = 0; i < gradeLevel.getGrades().size(); i++) {
//            GradeJSON gradeJSON = new GradeJSON(gradeLevel.getGrades().get(i).getGradeId() , gradeLevel.getGrades().get(i).getGrade());
//            gradeJSONS.add(gradeJSON);
//        }

//        for (int i = 0; i < gradeJSONS.size() -1; i++)
//        {
//            for (int j = 1; j < gradeJSONS.size(); j++)
//            {
//
//                if (gradeJSONS.get(i).equals(gradeJSONS.get(j)))
//                {
//                    gradeJSONS.remove(i);
//                }
//            }
//        }

        return gradeJSONS;
    }

    @GetMapping("/offer")
    public List<Offer> getOffers() {
        return offerService.getOffers();
    }




}