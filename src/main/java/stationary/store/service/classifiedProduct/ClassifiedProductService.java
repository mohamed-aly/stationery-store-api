package stationary.store.service.classifiedProduct;

import stationary.store.model.ClassifiedProduct;

import java.util.List;


public interface ClassifiedProductService {

    List<ClassifiedProduct> getClassifiedProducts();

    void saveClassifiedProduct(ClassifiedProduct theClassifiedProduct);

    ClassifiedProduct getClassifiedProduct(int theId);

    void deleteClassifiedProduct(int theId);

}
