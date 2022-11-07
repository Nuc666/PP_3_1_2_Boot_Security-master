package testwork.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    private Long id;

    private String userRole;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String getAuthority() {
        return getUserRole();
    }

}
