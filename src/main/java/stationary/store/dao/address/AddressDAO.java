package stationary.store.dao.address;

import stationary.store.model.Address;

import java.util.List;

public interface AddressDAO {

    List<Address> getAddresses();

    void saveAddress(Address address);

    Address getAddress(int id);

    void deleteAddress(int id);

}
