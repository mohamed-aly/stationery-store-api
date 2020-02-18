package stationary.store.service.userType;

import stationary.store.model.UserType;

import java.util.List;


public interface UserTypeService {

    List<UserType> getUserTypes();

    void saveUserType(UserType theUserType);

    UserType getUserType(int theId);

    void deleteUserType(int theId);

}
