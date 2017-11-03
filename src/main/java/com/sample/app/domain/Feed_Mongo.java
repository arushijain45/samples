package com.sample.app.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A Feed.
 */
@Document(collection = "FEED")
@TypeAlias(value="type.parent.feed")
public class Feed_Mongo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("feed_type")
	@Indexed(background=true)
	private String feedType;

	@Field("feed_created_by_user_id")
	@Indexed(background=true)
	private String feedCreatedByUserId;

	/*@Field("title")
    private String title;*/

	@Field("description")
	@TextIndexed(weight=3)
	private String description;

	@Field("time_created")
	@Indexed(background=true, direction=IndexDirection.DESCENDING)
	private DateTime timeCreated;

	@Field("sorted_time")
	@Indexed(background=true, direction=IndexDirection.DESCENDING)
	private DateTime sortedTime;

	@Field("thumbnail_url")
	private String thumbnailUrl;

	@Field("inspired_num")
	@Indexed(background=true, direction=IndexDirection.DESCENDING)
	private int inspiredNum;

	@Field("views_num")
	private int viewsNum;

	@Field("comments_num")
	private int commentsNum;

	/**Contest parameters*/
	@Field("contest_id")
	private String contestId;	
	@Field("contest_title")
	private String contestTitle;

	/**Collection parameters*/
	@Field("collection_id")
	private String collectionId;	
	@Field("collection_title")
	private String collectionTitle;

	/**True if all the tags of feed are correct and verified by admin.*/
	@Field("is_tags_verified")
	@Indexed(background=true)
	private boolean isTagsVerified;

	public Feed_Mongo(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
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

	public int getCommentsNum() {
		return commentsNum;
	}

	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}

	public DateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(DateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getFeedCreatedByUserId() {
		return feedCreatedByUserId;
	}

	public void setFeedCreatedByUserId(String feedCreatedByUserId) {
		this.feedCreatedByUserId = feedCreatedByUserId;
	}
	
	public String getContestId() {
		return contestId;
	}

	public void setContestId(String contestId) {
		this.contestId = contestId;
	}

	public String getContestTitle() {
		return contestTitle;
	}

	public void setContestTitle(String contestTitle) {
		this.contestTitle = contestTitle;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionTitle() {
		return collectionTitle;
	}

	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}


	public DateTime getSortedTime() {
		return sortedTime;
	}

	public void setSortedTime(DateTime sortedTime) {
		this.sortedTime = sortedTime;
	}

	public boolean isTagsVerified() {
		return isTagsVerified;
	}

	public void setTagsVerified(boolean isTagsVerified) {
		this.isTagsVerified = isTagsVerified;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Feed_Mongo feed = (Feed_Mongo) o;

		if ( ! Objects.equals(id, feed.id)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Feed{" +
				"id=" + id +
				", feedType='" + feedType + "'" +
				", inspiredNum='" + inspiredNum + "'" +
				", viewsNum='" + viewsNum + "'" +
				", commentsNum='" + commentsNum + "'" +
				", timeCreated='" + timeCreated + "'" +
				", description='" + description + "'" +
				", thumbnailUrl='" + thumbnailUrl + "'" +
				'}';
	}
}
