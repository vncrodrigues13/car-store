package com.vncrodrigues13.carstore.user;

import com.vncrodrigues13.carstore.exceptions.BusinessLogicException;
import com.vncrodrigues13.carstore.exceptions.EmptyFirstNameException;
import com.vncrodrigues13.carstore.exceptions.EmptyLastNameException;
import com.vncrodrigues13.carstore.models.Contact;
import com.vncrodrigues13.carstore.models.User;
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

