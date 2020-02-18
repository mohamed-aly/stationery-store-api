package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.ClassifiedProductDAO;
import stationary.store.model.ClassifiedProduct;

import java.util.List;


@Service
public class ClassifiedProductServiceImpl implements ClassifiedProductService {

    // need to inject ClassifiedProduct dao
    @Autowired
    private ClassifiedProductDAO classifiedProductDAO;

    @Override
    @Transactional
    public List<ClassifiedProduct> getClassifiedProducts() {
        return classifiedProductDAO.getClassifiedProducts();
    }

    @Override
    @Transactional
    public void saveClassifiedProduct(ClassifiedProduct theClassifiedProduct) {

        classifiedProductDAO.saveClassifiedProduct(theClassifiedProduct);
    }

    @Override
    @Transactional
    public ClassifiedProduct getClassifiedProduct(int theId) {

        return classifiedProductDAO.getClassifiedProduct(theId);
    }

    @Override
    @Transactional
    public void deleteClassifiedProduct(int theId) {

        classifiedProductDAO.deleteClassifiedProduct(theId);
    }
}





