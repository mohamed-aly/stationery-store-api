package stationery.store.bundle.category;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import stationery.store.bundle.product.Product;
import stationery.store.bundle.product.ProductService;
import stationery.store.exceptions.EmailExistsException;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    private ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping({"", "/all"})
    public Set<Category> getAll() {

        Set<Category> categories = categoryService.findAll();

        return categories;
    }

    @GetMapping(value = "/paged")
    public List<Category> getCategories(@RequestParam(value = "page", required = false, defaultValue = "5") Integer page,
                                        @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                        @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        return categoryService.findAll(page, size, sort);
    }

    @GetMapping("/{id}")
    public Category findByID(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/{id}/products")
    public Set<Product> getCategoryProducts(@PathVariable Long id,
                                            @RequestParam(value = "page", defaultValue = "5") int page,
                                            @RequestParam(value = "size", defaultValue = "10") int size,
                                            @RequestParam(value = "sort", defaultValue = "id") String sort) {
        return productService.getCategoryProducts(id, page, size, sort);
    }

    @GetMapping("/{id}/categories")
    public Set<Category> getCategorySubCategories(@PathVariable Long id,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "5") int size,
                                                  @RequestParam(value = "sort", defaultValue = "id") String sort) {
        return categoryService.findSubCategories(id, page, size, sort);
    }

    @GetMapping("/main")
    public Set<Category> findMainCategories() {
        return categoryService.findMainCategories();
    }

    @PostMapping({"", "/save"})
    public Category save(@RequestBody Category category) throws EmailExistsException {
        return categoryService.save(category);
    }

    @PatchMapping({"", "/update"})
    public Category update(@RequestBody Category category) throws EmailExistsException {
        return categoryService.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }


}
	

	

















