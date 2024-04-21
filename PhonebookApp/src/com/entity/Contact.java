package com.entity;

public class Contact {

	private int id;
	private String name;
	private String phoneno;
	private String email;
	private String about;
	private int userid;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String name, String phoneno, String email, String about, int userid) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.about = about;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

}
