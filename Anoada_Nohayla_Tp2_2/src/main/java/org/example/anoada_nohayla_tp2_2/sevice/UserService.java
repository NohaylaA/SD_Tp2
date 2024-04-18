package org.example.anoada_nohayla_tp2_2.sevice;

import org.example.anoada_nohayla_tp2_2.entities.Role;
import org.example.anoada_nohayla_tp2_2.entities.User;

public interface UserService
{
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
    User authenticate(String userName, String password);
}
