package com.entity;

public class Admin {
	private int aid;
    private String apwd;
    private String aname;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int aid, String apwd, String aname) {
		super();
		this.aid = aid;
		this.apwd = apwd;
		this.aname = aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
    
}
