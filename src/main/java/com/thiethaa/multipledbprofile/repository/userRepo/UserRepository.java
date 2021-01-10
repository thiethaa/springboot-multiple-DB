package com.thiethaa.multipledbprofile.repository.userRepo;

import com.thiethaa.multipledbprofile.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
