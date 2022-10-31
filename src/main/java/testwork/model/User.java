package testwork.model;


import org.hibernate.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   private String password;

   private boolean isActive = true;



   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
        name = "User_role",
        joinColumns = { @JoinColumn(name = "users_id") },
        inverseJoinColumns = { @JoinColumn(name = "roles_id") }
)
   private List<Role> roleList;



   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   public List<Role> getRoleList() {
      return roleList;
   }
   public void setRoleList(List<Role> roleList) {
      this.roleList = roleList;
   }
   public void setPassword(String password) {
      this.password = password;
   }

   public boolean getIsActive() {
      return isActive;
   }

   public void setActive(boolean active) {
      isActive = active;
   }



   @Override
   public String toString() {
      return "User{" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              '}';
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return getRoleList();
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return firstName;
   }

   @Override
   public boolean isAccountNonExpired() {
      return getIsActive();
   }

   @Override
   public boolean isAccountNonLocked() {
      return getIsActive();
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return getIsActive();
   }

   @Override
   public boolean isEnabled() {
      return getIsActive();
   }
}
