package com.assignment.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.assignment.custom.serialize.Employee;
import com.assignment.list.sort.Student;
import com.assignment.pyramid.Pyramid;

public class Main {

	public static void main(String[] args) {
		
		// Assignment 1: 
		sortStudentList();
		
		//Assignment 2: custom serialize Employee object
		//serializeDeserializeEmployeeOject();
		
		// Assignment 3: pyramid 
		//Pyramid.draw(4);
		
	}

	private static void serializeDeserializeEmployeeOject() {
		Employee e = new Employee();
		e.setAge(36);
		e.setName("Abc");
		e.setCreditCard("1234-5678-1245-9876");
		
		//write object (ser)
		serializeEmployee(e);

		//read (deser)
		deserializeEmployee();
	}


	private static void deserializeEmployee() {
		try {
			FileInputStream fis = new FileInputStream("employee.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee employee = (Employee) ois.readObject();
			
			System.out.println("The follwing is the desirealized object: " );
			System.out.println("Name: "+employee.getName());
			System.out.println("Age: "+employee.getAge());
			System.out.println("Card number ending with: "+employee.getCreditCard());
			
			ois.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
	}


	private static void serializeEmployee(Employee e) {
		try {
			FileOutputStream fos = new FileOutputStream("employee.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(e);
			oos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	private static void sortStudentList() {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student(1,"a"));
		studentList.add(new Student(2,"a"));
		studentList.add(new Student(3,"B"));
		studentList.add(new Student(0,"A"));
		
		Collections.sort(studentList);
		studentList.stream().forEach(s -> System.out.println(s.getName()+"("+s.getAge()+")"));
	}
}
