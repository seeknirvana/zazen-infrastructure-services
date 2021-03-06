package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.zazen.infrastructure.v1.repository.TimeStampedEntity;

@Entity
@Component
public class Answer extends TimeStampedEntity{
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Question question;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Recommendation recommendation;
	
	private long  fileId;
	
	private String answerRecommendation;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public Question getQuestion() {
		return question;
	}
	
	
	public void setQuestion(Question question) {
		this.question = question;
	}

	
	public Recommendation getRecommendation() {
		return recommendation;
	}

	
	public void setRecommendation(Recommendation recommendation) {
		this.recommendation = recommendation;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	private Date createdDate;

	public String getAnswerRecommendation() {
		return answerRecommendation;
	}

	public void setAnswerRecommendation(String answerRecommendation) {
		this.answerRecommendation = answerRecommendation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
