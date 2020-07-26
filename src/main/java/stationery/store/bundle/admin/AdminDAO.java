package stationery.store.bundle.admin;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminDAO extends CrudRepository<Admin, Long> {

    @Query("Select a from Admin a join fetch a.userType where a.email=:email")
    Admin findByEmail(String email);


}
