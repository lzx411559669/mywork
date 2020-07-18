package com.entity;

public class Teacher {
	private int tid;
	private String tpwd;
	private String tname;
	private String tgender;
	private Subject sj=new Subject();
	private Banji cl=new Banji();
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int tid, String tpwd, String tname, String tgender, Subject sj, Banji cl) {
		super();
		this.tid = tid;
		this.tpwd = tpwd;
		this.tname = tname;
		this.tgender = tgender;
		this.sj = sj;
		this.cl = cl;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTgender() {
		return tgender;
	}
	public void setTgender(String tgender) {
		this.tgender = tgender;
	}
	public Subject getSj() {
		return sj;
	}
	public void setSj(Subject sj) {
		this.sj = sj;
	}
	public Banji getCl() {
		return cl;
	}
	public void setCl(Banji cl) {
		this.cl = cl;
	}
	
}
