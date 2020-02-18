package stationary.store.dao.daos;

import stationary.store.model.UserType;

import java.util.List;

public interface UserTypeDAO {

    List<UserType> getUserTypes();

    void saveUserType(UserType UserType);

    UserType getUserType(int id);

    void deleteUserType(int id);

}
