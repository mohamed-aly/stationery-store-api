package stationary.store.dao.category;

import stationary.store.model.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getCategories();

    void saveCategory(Category Category);

    Category getCategory(int id);

    void deleteCategory(int id);

}