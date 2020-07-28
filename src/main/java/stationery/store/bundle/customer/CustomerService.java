package stationery.store.bundle.customer;


import stationery.store.bundle.abstractAndInterfaces.CrudService;
import stationery.store.bundle.user.User;
import stationery.store.bundle.user.UserType;
import stationery.store.exceptions.EmailExistsException;

public interface CustomerService extends CrudService<Customer, Long> {
    Customer getUserByEmail(String email);
    Customer updateExistingUser(Customer customer) throws EmailExistsException;

}
