package stationary.store.service.productImage;

import stationary.store.model.ProductImage;

import java.util.List;


public interface ProductImageService {

    List<ProductImage> getProductImages();

    void saveProductImage(ProductImage theProductImage);

    ProductImage getProductImage(int theId);

    void deleteProductImage(int theId);

}
