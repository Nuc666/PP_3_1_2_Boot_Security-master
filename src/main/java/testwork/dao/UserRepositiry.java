package testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testwork.model.User;

@Repository
public interface UserRepositiry extends JpaRepository<User, Long> {
    User findByFirstName(String name);
}
