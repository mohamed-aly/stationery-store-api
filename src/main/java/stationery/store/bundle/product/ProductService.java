package stationery.store.bundle.product;


import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> findAll();

    Set<Product> findBestSellers();

}
