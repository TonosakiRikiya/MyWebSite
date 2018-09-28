package beans;

import java.io.Serializable;

public class UserDatabeans implements Serializable{
	private String name;
	private String address;
	private String loginId;
	private String password;
	private int id;

	public UserDatabeans() {
		this.name = "";
		this.address = "";
		this.loginId = "";
		this.password = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setUpdateUserDataBeansInfo(String name, String loginId, String address, int id) {
		this.name = name;
		this.loginId = loginId;
		this.address = address;
		this.id = id;
	}
}
