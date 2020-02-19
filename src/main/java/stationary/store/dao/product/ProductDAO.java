package stationary.store.dao.product;

import stationary.store.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts();

    List<Product> getBestSellers(int limit);

    void saveProduct(Product Product);

    Product getProduct(int id);

    void deleteProduct(int id);

}
