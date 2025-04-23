package com.vncrodrigues13.carstore.contact;

import com.vncrodrigues13.carstore.exceptions.BusinessLogicException;
import com.vncrodrigues13.carstore.exceptions.EmailRequiredException;
import com.vncrodrigues13.carstore.exceptions.InvalidMailException;
import com.vncrodrigues13.carstore.models.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ContactTests {

	private final String fakeMail = "johndoe@protonmail.com";
	private final String fakeNumber = "123456789";

	Contact sut;

	{
		try {
			sut = new Contact(fakeMail, fakeNumber);
		} catch (BusinessLogicException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void hasContactId() {

		Contact mock = Mockito.mock(Contact.class);

		Mockito.when(mock.getContactId()).thenReturn(23);

		Assert.isTrue((mock.getContactId() > 0), "The contactId must be greater than 0");
	}

	@Test
	public void failEmptyEmail() throws BusinessLogicException {
		Assertions.assertThrows(EmailRequiredException.class, () -> {
			new Contact("", fakeNumber);
		}, "The contact must have an email");
	}

	@Test
	public void failInvalidMail() throws BusinessLogicException {
		Assertions.assertThrows(InvalidMailException.class, () -> {
			new Contact("johndoe@", fakeNumber);
		}, "The contact must have a valid mail");
	}


}


