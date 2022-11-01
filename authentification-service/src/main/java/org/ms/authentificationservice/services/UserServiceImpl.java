package org.ms.authentificationservice.services;

import lombok.AllArgsConstructor;
import org.ms.authentificationservice.entities.AppRole;
import org.ms.authentificationservice.entities.AppUser;
import org.ms.authentificationservice.repositories.AppRoleRepository;
import org.ms.authentificationservice.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser addUser(AppUser appUser) {

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser addRoleToUser(String username, String roleName) {
        AppUser user= appUserRepository.findByUsername(username);
        AppRole role= appRoleRepository.findByRoleName(roleName);
        user.addRole(role);
        appUserRepository.save(user);
        return user;

    }

    @Override
    public AppUser getUserByName(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
}
