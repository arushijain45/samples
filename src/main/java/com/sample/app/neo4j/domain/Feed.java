package com.sample.app.neo4j.domain;

import java.io.Serializable;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Feed implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GraphId
	private Long id;

	private String mongoFeedId;	
	@Index // If Needs to be added directly: CREATE INDEX ON :Feed(feedType)
	private String feedType;
	private Long timeCreated;	
	public Long sortedTime;
	private int inspiredNum;
	private int viewsNum;
	public int promotionType;
	@Index //If Needs to be added directly: CREATE INDEX ON :Feed(isTagsVerified)
	public boolean isTagsVerified;


	public Feed(){}
	
	//Getters and Setters
	
	public void incrementInspiredNum() {
		this.inspiredNum +=1;
	}

	public void incrementViewsNum(int count) {
		this.viewsNum += count;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMongoFeedId() {
		return mongoFeedId;
	}

	public void setMongoFeedId(String mongoFeedId) {
		this.mongoFeedId = mongoFeedId;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	

	public Long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public int getInspiredNum() {
		return inspiredNum;
	}

	public void setInspiredNum(int inspiredNum) {
		this.inspiredNum = inspiredNum;
	}

	public int getViewsNum() {
		return viewsNum;
	}

	public void setViewsNum(int viewsNum) {
		this.viewsNum = viewsNum;
	}

	public Long getSortedTime() {
		return sortedTime;
	}

	public void setSortedTime(Long sortedTime) {
		this.sortedTime = sortedTime;
	}

	public boolean isTagsVerified() {
		return isTagsVerified;
	}

	public void setTagsVerified(boolean isTagsVerified) {
		this.isTagsVerified = isTagsVerified;
	}

	public int getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(int promotionType) {
		this.promotionType = promotionType;
	}

	
}