package com.sample.app.neo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.sample.app.neo4j.domain.Feed;

public interface FeedRepository extends GraphRepository<Feed>{

	
	Feed findById(Long id);
	Feed findByMongoFeedId(String id);

	List<Feed> findByFeedType(String feedtype);	


}
