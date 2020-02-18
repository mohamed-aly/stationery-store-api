package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.ProductPatchDAO;
import stationary.store.model.ProductPatch;

import java.util.List;


@Service
public class ProductPatchServiceImpl implements ProductPatchService {

    // need to inject productPatch dao
    @Autowired
    private ProductPatchDAO productPatchDAO;

    @Override
    @Transactional
    public List<ProductPatch> getProductPatches() {
        return productPatchDAO.getProductPatches();
    }

    @Override
    @Transactional
    public void saveProductPatch(ProductPatch theProductPatch) {

        productPatchDAO.saveProductPatch(theProductPatch);
    }

    @Override
    @Transactional
    public ProductPatch getProductPatch(int theId) {

        return productPatchDAO.getProductPatch(theId);
    }

    @Override
    @Transactional
    public void deleteProductPatch(int theId) {

        productPatchDAO.deleteProductPatch(theId);
    }
}





