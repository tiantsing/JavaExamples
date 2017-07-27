package cn.terry.domain;

import java.util.Date;
/**
 * 用户实体类
 * @author tianq
 *
 */
public class User {
	private int id;
	private String username;//用户名
	private String pwd;//密码
	private String email;//邮箱
	private Date brithday;//生日

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usernam=" + username + ", pwd=" + pwd + ", email=" + email + ", brithday="
				+ brithday + "]";
	}
    
}
