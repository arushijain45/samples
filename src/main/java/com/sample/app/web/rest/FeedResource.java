package com.sample.app.web.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.sample.app.domain.Feed_Mongo;
import com.sample.app.neo4j.repository.FeedRepository;
import com.sample.app.repository.FeedMongoRepository;

/**
 * REST controller for managing Feed.
 */
@RestController
@RequestMapping("/api")
public class FeedResource {

	private final Logger log = LoggerFactory.getLogger(FeedResource.class);

	@Inject private FeedMongoRepository feedMongoRepo;
	@Inject FeedRepository feedNeoRepo;

	/**
	 * GET  /feeds/:id -> get the "id" feed.
	 */
	@RequestMapping(value = "/feeds/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<Feed_Mongo> get(@PathVariable String id, HttpServletResponse response) {
		log.debug("REST request to get Feed : {}", id);
		
		Feed_Mongo feed = new Feed_Mongo();
		feed.setDescription("dfgfdgfd");
		return new ResponseEntity<>(feed, HttpStatus.OK);
	}
}
