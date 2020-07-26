package stationery.store.bundle.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import stationery.store.bundle.userType.UserType;
import stationery.store.validation.PasswordMatches;
import stationery.store.validation.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@PasswordMatches
public class User extends BaseEntity implements UserDetails {

    @Column(name = "first_name")
    @NotEmpty(message = "first name is required.")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Column(name = "phone_number1")
    @NotEmpty(message = "Phone number is required.")
    private String phoneNumber1;

    @Column(name = "phone_number2")
    private String phoneNumber2;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "Email is required.")
    @Email
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password is required.")
    @ValidPassword
    private String password;

    @Transient
    private String passwordConfirmation;

    private LocalDate created = LocalDate.now();

    private int isEnabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "address-user")
    private Set<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    @JsonBackReference(value="userType-user")
    private UserType userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.getUserType().getType().toUpperCase()));
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
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
