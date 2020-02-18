package stationary.store.service.cartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.CartItemDAO;
import stationary.store.model.CartItem;

import java.util.List;


@Service
public class CartItemServiceImpl implements CartItemService {

    // need to inject CartItem dao
    @Autowired
    private CartItemDAO cartDAO;

    @Override
    @Transactional
    public List<CartItem> getCartItems() {
        return cartDAO.getCartItems();
    }

    @Override
    @Transactional
    public void saveCartItem(CartItem theCartItem) {

        cartDAO.saveCartItem(theCartItem);
    }

    @Override
    @Transactional
    public CartItem getCartItem(int theId) {

        return cartDAO.getCartItem(theId);
    }

    @Override
    @Transactional
    public void deleteCartItem(int theId) {

        cartDAO.deleteCartItem(theId);
    }
}





