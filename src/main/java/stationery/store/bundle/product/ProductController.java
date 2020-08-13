package stationery.store.bundle.product;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
       return productService.findAll();
    }

    @GetMapping(value = "/paged", params = {"page", "size"})
    public List<Product> getProducts(@RequestParam("page") int page, @RequestParam("size") int size) {
        return productService.findAll(page, size, null);
    }

    @GetMapping("/bestSellers")
    public Set<Product> getBestSellers() {
        return productService.findBestSellers();
    }

}
