package testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import testwork.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
