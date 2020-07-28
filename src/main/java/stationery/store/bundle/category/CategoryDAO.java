package stationery.store.bundle.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

}
