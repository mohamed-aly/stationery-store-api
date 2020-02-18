package stationary.store.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.ProductDAO;
import stationary.store.model.Product;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    // need to inject product dao
    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {

        productDAO.saveProduct(theProduct);
    }

    @Override
    @Transactional
    public Product getProduct(int theId) {

        return productDAO.getProduct(theId);
    }

    @Override
    @Transactional
    public void deleteProduct(int theId) {

        productDAO.deleteProduct(theId);
    }
}





