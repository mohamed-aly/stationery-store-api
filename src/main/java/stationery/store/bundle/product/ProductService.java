package stationery.store.bundle.product;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stationery.store.bundle.category.Category;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> findAll();

    List<Product> findAll(int page, int pageSize, String sortBy);

    Set<Product> findBestSellers();

    Set<Product> getCategoryProducts(long categoryId, int page, int size, String sort);

}
