package testwork.dao;


import testwork.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements testwork.dao.UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void editUser(User modifiedUser, Long id) {
        User currentUser = getUser(id);
        if (!modifiedUser.getFirstName().isBlank()) {
            currentUser.setFirstName(modifiedUser.getFirstName());
        }
        if (!modifiedUser.getLastName().isBlank()) {
            currentUser.setLastName(modifiedUser.getLastName());
        }
        if (!modifiedUser.getEmail().isBlank()) {
            currentUser.setEmail(modifiedUser.getEmail());
        }
        if (!modifiedUser.getRoleList().isEmpty()) {
            currentUser.setRoleList(modifiedUser.getRoleList());
        }

        entityManager.persist(currentUser);
    }

    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    public User getUser(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =: id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
