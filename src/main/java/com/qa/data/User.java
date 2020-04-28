package com.qa.data;

public class User {
	
	String name,job,createdAt,id;
	
	
public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public void setId(String id) {
		this.id = id;
	}
	//pojo plane old java object
	public User() {
		
	}
	public User(String name,String job) {
		this.name=name;
		this.job=job;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	

}
