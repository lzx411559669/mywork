package com.entity;

public class Tests {
	private int testsno;
	private int condition;
	private Banji cl=new Banji();
	private Subject sj=new Subject();
	public Tests() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tests(int testsno, int condition, Banji cl, Subject sj) {
		super();
		this.testsno = testsno;
		this.condition = condition;
		this.cl = cl;
		this.sj = sj;
	}
	public int getTestsno() {
		return testsno;
	}
	public void setTestsno(int testsno) {
		this.testsno = testsno;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public Banji getCl() {
		return cl;
	}
	public void setCl(Banji cl) {
		this.cl = cl;
	}
	public Subject getSj() {
		return sj;
	}
	public void setSj(Subject sj) {
		this.sj = sj;
	}
	
}
