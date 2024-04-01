package com.studentmanagement;



public class Student {
	
	private int Id;
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private String course;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Student(int id, String firstname, String lastname, String gender, int age, String course) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.course = course;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Students [Id=" + Id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", age=" + age + ", course=" + course + "]";
	}
	
	
	

}
