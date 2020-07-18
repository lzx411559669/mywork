package com.entity;

public class Forcorrect {
	private int fcno;
	private int xztmark;
	private int zgtno1;
	private String zgtda1;
	private int zgtno2;
	private String zgtda2;
	private int condition;
	private int testsno;
	private Subject sj=new Subject();
	private Student stu=new Student();
	public Forcorrect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Forcorrect(int fcno, int xztmark, int zgtno1, String zgtda1, int zgtno2, String zgtda2, int condition,
			int testsno, Subject sj, Student stu) {
		super();
		this.fcno = fcno;
		this.xztmark = xztmark;
		this.zgtno1 = zgtno1;
		this.zgtda1 = zgtda1;
		this.zgtno2 = zgtno2;
		this.zgtda2 = zgtda2;
		this.condition = condition;
		this.testsno = testsno;
		this.sj = sj;
		this.stu = stu;
	}
	public int getFcno() {
		return fcno;
	}
	public void setFcno(int fcno) {
		this.fcno = fcno;
	}
	public int getXztmark() {
		return xztmark;
	}
	public void setXztmark(int xztmark) {
		this.xztmark = xztmark;
	}
	public int getZgtno1() {
		return zgtno1;
	}
	public void setZgtno1(int zgtno1) {
		this.zgtno1 = zgtno1;
	}
	public String getZgtda1() {
		return zgtda1;
	}
	public void setZgtda1(String zgtda1) {
		this.zgtda1 = zgtda1;
	}
	public int getZgtno2() {
		return zgtno2;
	}
	public void setZgtno2(int zgtno2) {
		this.zgtno2 = zgtno2;
	}
	public String getZgtda2() {
		return zgtda2;
	}
	public void setZgtda2(String zgtda2) {
		this.zgtda2 = zgtda2;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getTestsno() {
		return testsno;
	}
	public void setTestsno(int testsno) {
		this.testsno = testsno;
	}
	public Subject getSj() {
		return sj;
	}
	public void setSj(Subject sj) {
		this.sj = sj;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
}
