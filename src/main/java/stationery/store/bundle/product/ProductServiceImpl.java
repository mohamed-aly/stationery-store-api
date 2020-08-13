package stationery.store.bundle.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationery.store.bundle.category.Category;
import stationery.store.utilities.Utils;

import java.util.*;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;


    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO=productDAO;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        log.debug("I'm in the product service");

        List<Product> productDAOAll = productDAO.findAll();
        return productDAOAll;
    }

    @Override
    public List<Product> findAll(int page, int pageSize, String sortBy) {

        Pageable pageable = Utils.pageable(page, pageSize, sortBy);
        Page<Product> products =  productDAO.findAll(pageable);

        List<Product> productSet = new LinkedList<>();
        products.iterator().forEachRemaining(productSet::add);

        return productSet;
    }


    @Override
    public Set<Product> findBestSellers() {
        return productDAO.findBestSellers();
    }


    @Override
    public Set<Product> getCategoryProducts(long categoryId, int page, int size, String sort) {
        Pageable pageable = Utils.pageable(page, size, sort);
        Category category = new Category();
        category.setId(categoryId);
        Set<Product> products = productDAO.findByCategory(category, pageable).toSet();
        return products;
    }
}





