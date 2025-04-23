package com.vncrodrigues13.carstore.models;

import com.vncrodrigues13.carstore.exceptions.BusinessLogicException;
import com.vncrodrigues13.carstore.exceptions.EmailRequiredException;
import com.vncrodrigues13.carstore.util.RegexUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contact")
public class Contact {

	@Id
	private int contactId;
	private String email;
	private String number;

	public Contact(String email, String number) throws BusinessLogicException {
		super();
		setEmail(email);
		this.number = number;
	}

	public Contact(int contactId, String email, String number) throws BusinessLogicException {

		this(email, number);
		setContactId(contactId);
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) throws BusinessLogicException {

		if (email == null && email.trim().isEmpty())
			throw new EmailRequiredException();

		RegexUtil.validateEmail(email);
		this.email = email;
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String number) {

		this.number = number;
	}

	public void setContactId(int contactId) {

		this.contactId = contactId;
	}

	public int getContactId() {

		return contactId;
	}
}
