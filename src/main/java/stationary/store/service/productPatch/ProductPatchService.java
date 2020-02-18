package stationary.store.service.productPatch;

import stationary.store.model.ProductPatch;

import java.util.List;


public interface ProductPatchService {

    List<ProductPatch> getProductPatches();

    void saveProductPatch(ProductPatch theProductPatch);

    ProductPatch getProductPatch(int theId);

    void deleteProductPatch(int theId);

}
