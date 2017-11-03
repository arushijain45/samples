package com.sample.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sample.app.domain.Feed_Mongo;

/**
 * Spring Data MongoDB repository for the TagProfile entity.
 */
public interface FeedMongoRepository extends MongoRepository<Feed_Mongo,String> {

	
	
}
