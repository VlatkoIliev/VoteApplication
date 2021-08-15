package com.VoteApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VoteApplication.domain.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long>{
	

}
