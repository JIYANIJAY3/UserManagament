package service;

public interface FormDataValidationInterface {
	
	public boolean isName(String name);
	public boolean isEmail(String email);
	public boolean isPassword(String password);
	public boolean isImage(String image);
}
