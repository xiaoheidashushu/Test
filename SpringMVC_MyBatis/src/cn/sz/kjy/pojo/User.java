package cn.sz.kjy.pojo;

import java.io.Serializable;

public class User implements Serializable{
	private Integer userid;
	private String username;
	private String userpassword;
	private String realname;
	public User() {
	}
	
	public User(Integer userid, String username, String userpassword,
			String realname) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.realname = realname;
	}

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
