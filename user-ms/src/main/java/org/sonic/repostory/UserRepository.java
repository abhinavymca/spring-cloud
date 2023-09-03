package org.sonic.repostory;

import org.sonic.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByUsername(String username);

    boolean existsByUsername(String username);

    void deleteByUsername(String username);
}
