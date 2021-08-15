package com.VoteApplication.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.VoteApplication.domain.Comment;
import com.VoteApplication.domain.Feature;
import com.VoteApplication.domain.User;
import com.VoteApplication.repository.CommentRepository;
import com.VoteApplication.repository.FeatureRepository;

@Controller
@RequestMapping("/products/{productId}/features/{featureId}/comments")
public class CommentController {
	
	@Autowired
	private FeatureRepository featureRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@GetMapping("")
	@ResponseBody
	public List<Comment> getComments(@PathVariable Long featureId) {
		List<Comment> findByFeatureId = commentRepo.findByFeatureId(featureId);
		//System.out.println(findByFeatureId);
		return findByFeatureId;
	}
	
	@PostMapping("")
	public String postComment(@AuthenticationPrincipal User user, @PathVariable Long productId, 
			@PathVariable Long featureId, Comment comment, @RequestParam(required=false) Long parentId, @RequestParam(required=false) String childCommentText) {
		
		Optional<Feature> featureOpt = featureRepo.findById(featureId);
		if(parentId != null) {
			comment = new Comment();
			Optional<Comment> parentCommentOpt = commentRepo.findById(parentId);
			if(parentCommentOpt.isPresent())
				comment.setComment(parentCommentOpt.get());
			comment.setText(childCommentText);
		}
		
		if(featureOpt.isPresent())
			comment.setFeature(featureOpt.get());
		comment.setUser(user);
		comment.setCreatedAt(new Date());
		commentRepo.save(comment);
		return "redirect:/products/" +productId + "/features/"+ featureId;
		
	}

}
