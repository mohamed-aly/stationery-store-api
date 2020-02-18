package stationary.store.service;

import stationary.store.model.Shipper;

import java.util.List;


public interface ShipperService {

    List<Shipper> getShippers();

    void saveShipper(Shipper theShipper);

    Shipper getShipper(int theId);

    void deleteShipper(int theId);

}
