package stationery.store.bundle.userType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stationery.store.bundle.abstractAndInterfaces.BaseEntity;
import stationery.store.bundle.user.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_type")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserType extends BaseEntity {

    private String type;

    @OneToMany(mappedBy = "userType")
    @JsonManagedReference(value="userType-user")
    private Set<User> users;

    public UserType(String type){
        this.type=type;
    }


}
