package stationery.store.bundle.admin;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stationery.store.bundle.user.User;

@Repository
public interface AdminDAO extends CrudRepository<Admin, Long> {


}
