package service;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;
import bean.UserBean;
import dao.AddressDao;
import dao.RegistrationDao;

public class UserImpl implements UserInterface {
	RegistrationDao registrationDao = new RegistrationDao();
	AddressDao addressDao = new AddressDao();

	@Override
	public int getUserStatus(Connection conn, UserBean userBean) {
		return registrationDao.addEmployee(conn, userBean);
	}

	@Override
	public int getUserId(Connection conn, String Email) {

		return registrationDao.getEmployeeId(conn, Email);
	}

	@Override
	public int getUserAddressStatus(Connection conn, List<UserAddressBean> addressList) {

		return registrationDao.addEmployeeAddress(conn, addressList);
	}

	@Override
	public List<UserBean> getAllUser(Connection conn) {
		return registrationDao.getAllUser(conn);
	}

	@Override
	public boolean getEmailIsPresent(Connection conn, String Email) {
		return registrationDao.getEmailIsPresent(conn, Email);
	}

	@Override
	public int deleteUserById(Connection conn, int UserId) {
		return registrationDao.deleteUserById(conn, UserId);
	}

	@Override
	public List<UserAddressBean> getUserAddress(Connection conn, int UserId) {
		return addressDao.getUserAddress(conn, UserId);
	}

	@Override
	public int updateUser(Connection conn, UserBean userBean) {
		return registrationDao.updateEmployeeDetails(conn, userBean);
	}

	@Override
	public int forgetPassword(Connection conn, String email, String answer) {
		return registrationDao.forgetPassword(conn, email, answer);
	}

	@Override
	public int updatePassword(Connection conn, int UserId, String Password) {
		return registrationDao.updatePassword(conn, UserId, Password);
	}

	@Override
	public int updateUserAddress(Connection conn, List<UserAddressBean> addressList) {
		return addressDao.updateUserAddress(conn, addressList);
	}

	@Override
	public int addUserAddress(Connection conn, List<UserAddressBean> addressList) {
		return addressDao.addUserAddress(conn, addressList);
	}

	@Override
	public List<Integer> getUserAddressId(Connection conn, int UserId) {
		return addressDao.getUserAddressId(conn, UserId);
	}

	@Override
	public int deleteUserAddress(Connection conn, List<Integer> list, int UserId) {
		return addressDao.deleteUserAddress(conn, list, UserId);
	}

	@Override
	public UserBean getEmployeeByEmail(Connection conn, String email) {
		return registrationDao.getEmployeeByEmail(conn, email);
	}

}
