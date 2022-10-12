package br.eti.gadelha.security;

import br.eti.gadelha.persistence.model.Privilege;
import br.eti.gadelha.persistence.model.Role2;
import br.eti.gadelha.persistence.model.User2;
import br.eti.gadelha.persistence.repository.RepositoryPrivilege;
import br.eti.gadelha.persistence.repository.RepositoryRole2;
import br.eti.gadelha.persistence.repository.RepositoryUser2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private RepositoryUser2 userRepository;
    @Autowired
    private RepositoryRole2 roleRepository;
    @Autowired
    private RepositoryPrivilege privilegeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role2 adminRole = roleRepository.findByName("ROLE_ADMIN");
        User2 user = new User2();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role2 createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role2 role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role2(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}