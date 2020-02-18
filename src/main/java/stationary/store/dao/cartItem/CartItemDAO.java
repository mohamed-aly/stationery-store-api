package stationary.store.dao.cartItem;

import stationary.store.model.CartItem;

import java.util.List;

public interface CartItemDAO {

    List<CartItem> getCartItems();

    void saveCartItem(CartItem CartItem);

    CartItem getCartItem(int id);

    void deleteCartItem(int id);

}
