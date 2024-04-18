package org.example.anoada_nohayla_tp2_2.repositories;

import org.example.anoada_nohayla_tp2_2.entities.Role;
import org.example.anoada_nohayla_tp2_2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String>
{
    Role findByRoleName(String roleName);
}
