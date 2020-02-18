package stationary.store.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.address.AddressDAO;
import stationary.store.model.Address;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    // need to inject address dao
    @Autowired
    private AddressDAO addressDAO;

    @Override
    @Transactional
    public List<Address> getAddresses() {
        return addressDAO.getAddresses();
    }

    @Override
    @Transactional
    public void saveAddress(Address theAddress) {

        addressDAO.saveAddress(theAddress);
    }

    @Override
    @Transactional
    public Address getAddress(int theId) {

        return addressDAO.getAddress(theId);
    }

    @Override
    @Transactional
    public void deleteAddress(int theId) {

        addressDAO.deleteAddress(theId);
    }
}





