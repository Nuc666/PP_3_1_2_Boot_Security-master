package testwork.dao;


import testwork.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void editUser(User modifiedUser, Long id);

   void deleteUser(Long id);

   User getUser(Long id);


}
