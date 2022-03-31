package bean;

import jakarta.servlet.http.Part;

public class UserBean {

	private int UserId;
	private String FiratName;
	private String LastName;
	private String Dob;
	private String Role;
	private String SecutiryQuestion;
	private String MobailNo;
	private String Gender;
	private String answer;
	private String language;
	private String Hobby;
	private String Email;
	private String Password;
	private Part profile;
	private String base64Image;
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Part getProfile() {
		return profile;
	}

	public void setProfile(Part profile) {
		this.profile = profile;
	}

	public String getFiratName() {
		return FiratName;
	}

	public void setFiratName(String firatName) {
		FiratName = firatName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getSecutiryQuestion() {
		return SecutiryQuestion;
	}

	public void setSecutiryQuestion(String secutiryQuestion) {
		SecutiryQuestion = secutiryQuestion;
	}

	public String getMobailNo() {
		return MobailNo;
	}

	public void setMobailNo(String mobailNo) {
		MobailNo = mobailNo;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

}
