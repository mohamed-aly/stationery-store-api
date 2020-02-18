package stationary.store.service;

import stationary.store.model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> getCategories();

    void saveCategory(Category theCategory);

    Category getCategory(int theId);

    void deleteCategory(int theId);

}
