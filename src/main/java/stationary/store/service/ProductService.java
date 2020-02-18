package stationary.store.service;

import stationary.store.model.Product;

import java.util.List;


public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(int theId);

    void deleteProduct(int theId);

}
