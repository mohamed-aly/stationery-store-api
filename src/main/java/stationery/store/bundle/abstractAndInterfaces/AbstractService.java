package stationery.store.bundle.abstractAndInterfaces;

import stationery.store.bundle.product.Product;
import stationery.store.exceptions.EmailExistsException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface AbstractService<T, ID> {

    Collection<T> findAll();

    T findById(ID id);

    T save(T object) throws EmailExistsException;

    void delete(T object);

    void deleteById(ID id);
}
