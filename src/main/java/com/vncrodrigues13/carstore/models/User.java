package com.vncrodrigues13.carstore.models;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("user")
public class User {

	private int userId;
	@DBRef
	private Contact contact;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String governmentId;

	public User(String firstName, String lastName, Contact contact, Date birthDate, String governmentId) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setContact(contact);
		setBirthDate(birthDate);
		setGovernmentId(governmentId);
	}

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {

		this.userId = userId;
	}

	public Contact getContact() {

		return contact;
	}

	public void setContact(Contact contact) {

		this.contact = contact;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public Date getBirthDate() {

		return birthDate;
	}

	public void setBirthDate(Date birthDate) {

		this.birthDate = birthDate;
	}

	public String getGovernmentId() {

		return governmentId;
	}

	public void setGovernmentId(String governmentId) {

		this.governmentId = governmentId;
	}
}
