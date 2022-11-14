package testwork.service;


import testwork.dao.UserDao;
import testwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void editUser(User modifiedUser, Long id) {
      userDao.editUser(modifiedUser, id);
   }

   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }

   @Override
   public User getUser(Long id) {
     return userDao.getUser(id);
   }

   @Override
   public User getUserByName(String name) {

      return userDao.getUserByName(name);
   }


}
