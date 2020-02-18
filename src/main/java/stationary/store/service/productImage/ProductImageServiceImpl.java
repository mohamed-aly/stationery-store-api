package stationary.store.service.productImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.productImage.ProductImageDAO;
import stationary.store.model.ProductImage;

import java.util.List;


@Service
public class ProductImageServiceImpl implements ProductImageService {

    // need to inject productImage dao
    @Autowired
    private ProductImageDAO productImageDAO;

    @Override
    @Transactional
    public List<ProductImage> getProductImages() {
        return productImageDAO.getProductImages();
    }

    @Override
    @Transactional
    public void saveProductImage(ProductImage theProductImage) {

        productImageDAO.saveProductImage(theProductImage);
    }

    @Override
    @Transactional
    public ProductImage getProductImage(int theId) {

        return productImageDAO.getProductImage(theId);
    }

    @Override
    @Transactional
    public void deleteProductImage(int theId) {

        productImageDAO.deleteProductImage(theId);
    }
}





