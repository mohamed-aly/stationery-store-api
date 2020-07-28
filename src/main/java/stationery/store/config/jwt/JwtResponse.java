package stationery.store.config.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stationery.store.bundle.abstractAndInterfaces.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class JwtResponse extends BaseEntity {

    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
