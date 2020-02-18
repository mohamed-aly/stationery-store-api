package stationary.store.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.CategoryDAO;
import stationary.store.model.Category;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    // need to inject Category dao
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    @Transactional
    public void saveCategory(Category theCategory) {

        categoryDAO.saveCategory(theCategory);
    }

    @Override
    @Transactional
    public Category getCategory(int theId) {

        return categoryDAO.getCategory(theId);
    }

    @Override
    @Transactional
    public void deleteCategory(int theId) {

        categoryDAO.deleteCategory(theId);
    }
}





