package stationery.store.bundle.product;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stationery.store.bundle.category.Category;


import java.util.List;
import java.util.Set;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    @EntityGraph(value = "Product.imageUrl")
    Page<Product> findAll(Pageable pageable);
    
    @Query("select p from Product p " +
            "join p.orders po "+
            "where po.product.id=p.id " +
            "group by p order by sum(po.quantity) desc")
    @EntityGraph(value = "Product.imageUrl")
    Set<Product> findBestSellers();

    @Query("select p from Product p where p.category.id=:categoryId")
    Page<Product> getCategoryProducts(long categoryId, Pageable pageable);

    Page<Product> findByCategory(Category category, Pageable pageable);
}
