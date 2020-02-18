package stationary.store.dao.shipper;

import stationary.store.model.Shipper;

import java.util.List;

public interface ShipperDAO {

    List<Shipper> getShippers();

    void saveShipper(Shipper Shipper);

    Shipper getShipper(int id);

    void deleteShipper(int id);

}
