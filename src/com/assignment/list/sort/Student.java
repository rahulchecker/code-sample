package com.assignment.list.sort;

public class Student implements Comparable<Student>{
	private Integer age;
	private String name;

	public Student(Integer age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Student student) {
	     int nameCompare = this.name.toLowerCase().compareTo(student.name == null ? "" : student.name.toLowerCase());
	     if(nameCompare == 0) return this.age.compareTo(student.age);
	     return nameCompare;
	}

}