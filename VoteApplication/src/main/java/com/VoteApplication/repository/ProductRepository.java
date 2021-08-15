package com.VoteApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VoteApplication.domain.Product;
import com.VoteApplication.domain.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	  @Query("select p from Product p join fetch p.user where p.id = :id")
	  Optional<Product> findByIdWithUser(Long id);
	 
	
	  List<Product> findByUser(User user);
	
	  Optional<Product> findByName(String name);

}
