package cn.terry.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private int id;
	private String username;//用户名
	private String pwd;//密码
	private String pwdconfrim;
	private String email;//邮箱
	private String brithday;//生日
	
	Map<String, String> msg = new HashMap<String, String>();

	/*用户名：必须输入，且3~8位的字母组成<br>
	密码：必须输入，3~8位的数组组成<br>
	确认密码：和密码保持一致<br>
	邮箱：必须输入，且要符合邮箱的格式<br>
	生日：必须输入，符合yyyy-MM-dd的格式<br>*/
	public boolean validate(){
		
		if("".equals(username)){
			msg.put("username", "用户名不能为空！");
		}else if(!username.matches("\\w{3,8}")){//用户名：必须输入，且3~8位的字母组成<br>
			msg.put("username", "用户名为3~8位的字母组成");
		}
		
		if("".equals(pwd)){
			msg.put("pwd", "密码不能为空！");
		}else if(!pwd.matches("\\d{3,8}")){//密码：必须输入，3~8位的数组组成<br>
			msg.put("pwd", "密码为3~8位的数字组成");
		}
		
		//确认密码：和密码保持一致<br>
		if(!pwdconfrim.equals(pwd)){
			msg.put("pwdconfrim", "两次密码不一致！");
		}
		
		//邮箱：必须输入，且要符合邮箱的格式<br>
		if("".equals(email)){
			msg.put("email", "邮箱不能为空！");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
			msg.put("email", "邮箱格式不正确！");
		}
		
		//生日：必须输入，符合yyyy-MM-dd的格式<br>
//		if("".equals(brithday)){
//			msg.put("brithday", "生日不能为空！");
//		}else {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			try {
//				sdf.parse(brithday);
//			} catch (ParseException e) {
//				msg.put("brithday", "生日格式不正确！");
//			}
//		}
		return msg.isEmpty();//当map集合中没有数据时，返回true
		
	}

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

	public String getPwdconfrim() {
		return pwdconfrim;
	}

	public void setPwdconfrim(String pwdconfrim) {
		this.pwdconfrim = pwdconfrim;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBirthday(String brithday) {
		this.brithday = brithday;
	}

	public Map<String, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}	
	
}
