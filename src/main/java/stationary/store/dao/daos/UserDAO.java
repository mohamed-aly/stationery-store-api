package stationary.store.dao.daos;

import stationary.store.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void saveUser(User User);

    User getUser(int id);

    void deleteUser(int id);

}
