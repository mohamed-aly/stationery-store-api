package stationery.store.bundle.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


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
    public Set<Product> findBestSellers() {
        return productDAO.findBestSellers();
    }
}





