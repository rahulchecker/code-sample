package com.assignment.custom.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee implements Externalizable{

	private int age;
	private String name;
	private String creditCard;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(age);
		out.writeObject(name);
		out.writeObject(creditCard.substring(creditCard.length() - 4));
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		age = in.readInt();
		name = in.readObject().toString();
		creditCard = in.readObject().toString();		
	}
}
