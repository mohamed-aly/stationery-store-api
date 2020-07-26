package stationery.store.bundle.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO<T extends User> extends CrudRepository<T, Long> {

    @Query("Select u from #{#entityName} u where u.email=:email")
    T findByEmail(String email);



}
