package com.vncrodrigues13.carstore.user;

import com.vncrodrigues13.carstore.exceptions.BusinessLogicException;
import com.vncrodrigues13.carstore.exceptions.EmptyFirstNameException;
import com.vncrodrigues13.carstore.exceptions.EmptyLastNameException;
import com.vncrodrigues13.carstore.models.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserTests {

	Contact contact;

	{
		try {
			contact = new Contact("johndoe@mail.com", "5581999999999");
		} catch (BusinessLogicException e) {
			throw new RuntimeException(e);
		}
	}

	User sut;

	{
		try {
			sut = new User("John", "Doe", contact, new Date(), "11253378499");
		} catch (BusinessLogicException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void failWhenEmptyFirstName() {
		Assertions.assertThrows(EmptyFirstNameException.class, () -> {
			new User("", "Doe", contact, new Date(), "11253378499");
		}, "Fail when doesn't have first name");

		Assertions.assertThrows(EmptyFirstNameException.class, () -> {
			new User(null, "Doe", contact, new Date(), "11253378499");
		}, "Fail when doesn't have first name");
	}

	@Test
	public void failWhenEmptyLastName() {
		Assertions.assertThrows(EmptyLastNameException.class, () -> {
			new User("John", "", contact, new Date(), "11253378499");
		}, "Fail when doesn't have last name");

		Assertions.assertThrows(EmptyLastNameException.class, () -> {
			new User("John", null, contact, new Date(), "11253378499");
		}, "Fail when doesn't have last name");
	}
}

class User {

	private int userId;
	private Contact contact;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String governmentId;

	public User(String firstName, String lastName, Contact contact, Date birthDate, String governmentId)
			throws BusinessLogicException {
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

	public void setFirstName(String firstName) throws EmptyFirstNameException {
		if (firstName == null || firstName.trim().isEmpty())
			throw new EmptyFirstNameException();
		this.firstName = firstName;
	}

	public String getLastName() throws EmptyLastNameException {

		return lastName;
	}

	public void setLastName(String lastName) throws EmptyLastNameException {
		if (lastName == null || lastName.trim().isEmpty())
			throw new EmptyLastNameException();

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
