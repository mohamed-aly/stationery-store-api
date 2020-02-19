package stationary.store.service.category;

import stationary.store.model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> getCategories();

    List<Category> getCategories(int limit);

    void saveCategory(Category theCategory);

    Category getCategory(int theId);

    void deleteCategory(int theId);

}
