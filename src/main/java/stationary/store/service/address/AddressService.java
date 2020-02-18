package stationary.store.service.address;


import stationary.store.model.Address;

import java.util.List;


public interface AddressService {

    List<Address> getAddresses();

    void saveAddress(Address theAddress);

    Address getAddress(int theId);

    void deleteAddress(int theId);

}
