package stationery.store.bundle.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface ProductDAO extends JpaRepository<Product, Long> {


    @Query(" select p From Product p left join fetch p.imageUrl")
    List<Product> findAll();


    @Query("select p from Product p " +
            "left join fetch p.imageUrl " +
            "join p.orders po "+
            "where po.product.id=p.id " +
            "group by p order by sum(po.quantity) desc")
    Set<Product> findBestSellers();

//    @Query("select p.id from Product p " +
//            "join p.orders po "+
//            "where po.product.id=p.id " +
//            "group by p order by sum(po.quantity) desc ")
//    Long[] findBestSellersIds();
//
//
//    @Query("select p from Product p " +
//            "left join fetch p.imageUrl " +
//            "where p.id in (:ids)")
//    Set<Product> findBestSellers(@Param("ids") Long[] ids);



}
