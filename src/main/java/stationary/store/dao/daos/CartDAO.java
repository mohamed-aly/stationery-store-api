package stationary.store.dao.daos;

import stationary.store.model.Cart;

import java.util.List;

public interface CartDAO {

    List<Cart> getCarts();

    void saveCart(Cart Cart);

    Cart getCart(int id);

    void deleteCart(int id);

}
