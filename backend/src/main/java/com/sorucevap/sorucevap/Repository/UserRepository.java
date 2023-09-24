package com.sorucevap.sorucevap.Repository;

import com.sorucevap.sorucevap.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
