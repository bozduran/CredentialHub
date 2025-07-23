package bozntouran.credentialhub.dto;

import bozntouran.credentialhub.entities.Role;
import bozntouran.credentialhub.entities.UserData;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    /*
    * this class implements user details witch is need by spring security
    * and AuthenticationProvider it is used as a DTO from the UserData -> UserPrincipal
    * and it is used by the AuthenticationProvider
    * it uses the userData which is an entity and stores user data in the db
    * */
    private UserData userData;

    public UserPrincipal(UserData userData) {
        this.userData = userData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles = userData.getRoles();
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()) )
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.userData.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userData.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
