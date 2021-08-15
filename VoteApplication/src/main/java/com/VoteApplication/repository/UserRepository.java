package com.VoteApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.VoteApplication.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
