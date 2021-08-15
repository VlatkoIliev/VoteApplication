package com.VoteApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VoteApplication.domain.Feature;
import com.VoteApplication.domain.Product;
import com.VoteApplication.domain.User;
import com.VoteApplication.repository.FeatureRepository;
import com.VoteApplication.repository.ProductRepository;

@Service
public class FeatureService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private FeatureRepository featureRepo;
	
	public Feature createFeature(Long productId, User user) {
		
		Feature feature = new Feature();
		
		Optional<Product> productOpt = productRepo.findById(productId);
		
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			
			feature.setProduct(product);
			product.getFeatures().add(feature);
			
			feature.setUser(user);
			user.getFeatures().add(feature);
			
			feature.setStatus("Pending review");
			return featureRepo.save(feature);
		}
		
		return feature;
		
	}

	public Feature save(Feature feature) {
		return featureRepo.save(feature);
		
	}

	public Optional<Feature> findById(Long featureId) {
		return featureRepo.findById(featureId);
	}

}
