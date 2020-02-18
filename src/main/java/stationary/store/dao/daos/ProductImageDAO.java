package stationary.store.dao.daos;

import stationary.store.model.ProductImage;

import java.util.List;

public interface ProductImageDAO {

    List<ProductImage> getProductImages();

    void saveProductImage(ProductImage ProductImage);

    ProductImage getProductImage(int id);

    void deleteProductImage(int id);

}
