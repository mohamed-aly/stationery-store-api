package stationary.store.service.cart;

import stationary.store.model.Cart;

import java.util.List;


public interface CartService {

    List<Cart> getCarts();

    void saveCart(Cart theCart);

    Cart getCart(int theId);

    void deleteCart(int theId);

}
