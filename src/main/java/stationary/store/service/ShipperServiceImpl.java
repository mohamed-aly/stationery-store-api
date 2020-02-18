package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.ShipperDAO;
import stationary.store.model.Shipper;

import java.util.List;


@Service
public class ShipperServiceImpl implements ShipperService {

    // need to inject shipper dao
    @Autowired
    private ShipperDAO shipperDAO;

    @Override
    @Transactional
    public List<Shipper> getShippers() {
        return shipperDAO.getShippers();
    }

    @Override
    @Transactional
    public void saveShipper(Shipper theShipper) {

        shipperDAO.saveShipper(theShipper);
    }

    @Override
    @Transactional
    public Shipper getShipper(int theId) {

        return shipperDAO.getShipper(theId);
    }

    @Override
    @Transactional
    public void deleteShipper(int theId) {

        shipperDAO.deleteShipper(theId);
    }
}





