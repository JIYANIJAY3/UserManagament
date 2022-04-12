package bean;

import java.io.Serializable;
import java.util.List;

public class UserAddressBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int UserId;
	private int addressId;
	private String country;
	private String state;
	private String city;
	private String pinCode;
	private String address;
	private List<UserAddressBean> list;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public List<UserAddressBean> getList() {
		return list;
	}

	public void setList(List<UserAddressBean> list) {
		this.list = list;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
