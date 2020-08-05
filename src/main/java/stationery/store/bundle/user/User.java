package stationery.store.bundle.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import stationery.store.bundle.abstractAndInterfaces.BaseEntity;
import stationery.store.bundle.address.Address;
import stationery.store.validation.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User extends BaseEntity implements UserDetails {

    @NotEmpty(message = "first name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @NotEmpty(message = "Phone number is required.")
    private String phoneNumber1;

    private String phoneNumber2;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "Email is required.")
    @Email
    private String email;


    @NotEmpty(message = "Password is required.")
    @ValidPassword
    private String password;

    @Transient
    private String passwordConfirmation;

    private LocalDate created = LocalDate.now();

    @JsonIgnore
    private int isEnabled = 1;

    private String token;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "address-user")
    private Set<Address> addresses;

    //user type implementation block
    @Transient
    private UserType userType;

    @JsonIgnore
    private int type;

    @PostLoad
    void fillTransient() {
        if (type > 0) {
            this.userType = UserType.of(type);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (userType != null) {
            this.type = userType.getType();
        }
    }

    //end

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.getUserType().toString().toUpperCase()));
    }


    @JsonIgnore
    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        if (this.isEnabled == 1) {
            return true;
        }
        return false;
    }

    public void setEnabled(boolean isEnabled) {
        if(isEnabled)
        this.isEnabled = 1;
        else this.isEnabled=0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [email=" + email + "]";
    }

}
