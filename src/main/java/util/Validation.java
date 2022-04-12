package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean checkEmailValidation(String email) {

		String emailregex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);

		if (email.isEmpty()) {
			return false;
		} else if (!matcher.matches()) {
			return false;
		} else {
			return true;
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

	public static boolean checkDobValidation(String dob) {
		if (dob.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkGenderIsEmpty(String gender) {
		if (gender==null) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkAnswerValidation(String ans) {
		if (ans.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkMobailValidation(String mobail) {
		if (mobail.isEmpty()) {
			return false;
		} else if (!Pattern.matches("^[0-9]*$", mobail)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkPassowrdValidation(String password) {

		if (password.isEmpty()) {
			return false;
		} else if (password.length() < 8) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkCountryValidation(String country) {
		if (country.isEmpty()||country.isBlank()) {
			return false;
		} else if (!Pattern.matches("^[a-zA-Z]+", country)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkPincodeValidation(String pincode) {
		if (pincode.isEmpty()) {
			return false;
		} else if (!Pattern.matches("^[0-9]+", pincode)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkStateValidation(String state) {
		if (state.isEmpty() || state.isBlank()) {
			return false;
		} else if (!Pattern.matches("^[a-zA-Z]+", state)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkCityValidation(String city) {
		if (city.isEmpty()||city.isBlank()) {
			return false;
		} else if (!Pattern.matches("^[a-zA-Z]+", city)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkAddressValidation(String address) {
		if (address.isEmpty()||address.isBlank()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkProfileValidation(int i) {
		if (i==0) {
			return false;
		} else {
			return true;
		}
	}
}
