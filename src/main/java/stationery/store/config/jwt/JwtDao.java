package stationery.store.config.jwt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtDao extends CrudRepository<JwtResponse, Long> {

    JwtResponse findByToken(String token);
}
