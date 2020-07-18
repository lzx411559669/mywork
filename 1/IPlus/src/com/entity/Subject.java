package com.entity;

public class Subject {
	private int suid;
	private String suname;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(int suid, String suname) {
		super();
		this.suid = suid;
		this.suname = suname;
	}
	public int getSuid() {
		return suid;
	}
	public void setSuid(int suid) {
		this.suid = suid;
	}
	public String getSuname() {
		return suname;
	}
	public void setSuname(String suname) {
		this.suname = suname;
	}
	
}
