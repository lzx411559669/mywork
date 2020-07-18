package com.entity;

public class Student {
	private int sid;
    private String spwd;
    private String sname;
    private String sgender;
    private Banji cl=new Banji();
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String spwd, String sname, String sgender, Banji cl) {
		super();
		this.sid = sid;
		this.spwd = spwd;
		this.sname = sname;
		this.sgender = sgender;
		this.cl = cl;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public Banji getCl() {
		return cl;
	}
	public void setCl(Banji cl) {
		this.cl = cl;
	}
}
