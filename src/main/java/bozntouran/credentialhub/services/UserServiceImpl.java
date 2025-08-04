package bozntouran.credentialhub.services;

import bozntouran.credentialhub.dto.UserPrincipal;
import bozntouran.credentialhub.entities.UserData;
import bozntouran.credentialhub.reposistories.PrivilegeRepository;
import bozntouran.credentialhub.reposistories.RoleRepository;
import bozntouran.credentialhub.reposistories.UserDataRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UserServiceImpl implements UserDetailsService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(13);

    private final UserDataRepository userDataRepository;
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;

    @Autowired
    public UserServiceImpl(UserDataRepository userDataRepository, RoleRepository roleRepository, PrivilegeRepository privilegeRepository) {
        this.userDataRepository = userDataRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData userData = userDataRepository.findUserByUsername(username);

        if (userData == null) {
            log.error("User not found with username: {}", username);
            throw new UsernameNotFoundException(username);
        }else{
            log.info("Found user with username: {}", username);
            return new UserPrincipal(userData);
        }

    }


    public UserData registerNewUser(UserData userData) {
        userData.setId(null);
        userData.setRoles(List.of(roleRepository.getRoleByName("ROLE_USER")));

        // register new user
        userData.setPassword( bCryptPasswordEncoder.encode( userData.getPassword()) );
        return userDataRepository.save(userData);

    }

    public List<UserData> getAllUsers() {
        return userDataRepository.findAll();
    }

/*    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }*/
}
