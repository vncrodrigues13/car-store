package com.vncrodrigues13.carstore.models;

import com.vncrodrigues13.carstore.exceptions.BusinessLogicException;
import com.vncrodrigues13.carstore.exceptions.EmptyFirstNameException;
import com.vncrodrigues13.carstore.exceptions.EmptyLastNameException;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("user")
public class User {

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
