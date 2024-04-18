package org.example.anoada_nohayla_tp2_2.repositories;

import org.example.anoada_nohayla_tp2_2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{
    User findUserByUserName(String userName);
}
