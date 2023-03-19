package com.ecommerce.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Column(length = 100, name = "user_Name")
	private String username;
	@Id
	@Column(length = 45, name = "user_Email")
	private String useremail;
	@Column(length = 100, name = "user_Pass")
	private String userPassword;
	@Column(length = 12, name = "user_Phone")
	private String userphone;
	@Column(length = 1500, name = "user_pice")
	private String userpic;
	@Column(length = 1500, name = "user_address")
	private String userAdd;
	@Column(length = 1500, name = "user_type")
	private String userType;
	


	public User(String username, String useremail, String userPassword, String userphone, String userpic,
			String userAdd , String userType ) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.userPassword = userPassword;
		this.userphone = userphone;
		this.userpic = userpic;
		this.userAdd = userAdd;
		this.userType = userType;
	}
	
	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserpic() {
		return userpic;
	}

	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}

	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	@Override
	public String toString() {
		return "User [userIt=" + ", username=" + username + ", useremail=" + useremail + ", userPassword="
				+ userPassword + ", userphone=" + userphone + ", userpic=" + userpic + ", userAdd=" + userAdd + "]";
	}
	
	

}
