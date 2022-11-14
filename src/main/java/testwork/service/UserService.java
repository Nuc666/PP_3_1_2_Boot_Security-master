package testwork.service;


import testwork.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void editUser(User modifiedUser, Long id);

    void deleteUser(Long id);

    User getUser(Long id);


    User getUserByName(String name);

}
