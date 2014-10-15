package com.mushroom;

public class author {
	private int authorid;
	private String name;
	private int age;
	private String country;
	
	public author () {
		
	}
	public author (int authorid, String name, int age, String country) {
		this.authorid = authorid;
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
