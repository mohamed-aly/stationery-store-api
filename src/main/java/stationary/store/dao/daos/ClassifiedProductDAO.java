package stationary.store.dao.daos;

import stationary.store.model.ClassifiedProduct;

import java.util.List;

public interface ClassifiedProductDAO {

    List<ClassifiedProduct> getClassifiedProducts();

    void saveClassifiedProduct(ClassifiedProduct ClassifiedProduct);

    ClassifiedProduct getClassifiedProduct(int id);

    void deleteClassifiedProduct(int id);

}
