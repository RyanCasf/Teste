package br.com.parameters.email;

public class Email {

	public static boolean validar(String email) {
		return email != null && !email.trim().equals("");
	}
}