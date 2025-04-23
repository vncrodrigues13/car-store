package com.vncrodrigues13.carstore.util;

import com.vncrodrigues13.carstore.exceptions.InvalidMailException;

import java.util.regex.Pattern;

public class RegexUtil {

	private static final String MAIL_REGEX = "^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$";

	public static void validateEmail(String email) throws InvalidMailException {

		Pattern p = Pattern.compile(MAIL_REGEX);

		if (!p.matcher(email).matches()) {
			throw new InvalidMailException();
		}
	}
}
