package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static String checkEmailValidation(String email) {

		String emailregex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);

		if (email.isEmpty()) {
			return "Email Is Empty";
		} else if (!matcher.matches()) {
			return "Email Are Not Valide please enter proper email like - xxx@gmai.com";
		} else {
			return " ";
		}
	}

	public static boolean checkNameValidation(String name) {

		if (name.isEmpty()) {
			return false;
		} else if (!Pattern.matches("[a-zA-Z]+", name)) {
			return false;
		} else {
			return true;
		}
	}

	public static String checkPassowrdValidation(String password) {

		if (password.isEmpty()) {
			return "Password Is Empty";
		} else if (password.length() < 8) {
			return "Minimum 8 digit Required";
		} else {
			return " ";
		}

	}
}
