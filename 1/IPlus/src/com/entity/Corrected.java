package com.entity;

public class Corrected {
	private int cedno;
	private int xztmark;
	private int zgtmark;
	private int allmarker;
	private Teacher t=new Teacher();
	private Tests tests=new Tests();
	private Subject sj=new Subject();
	private Student s=new Student();
	public Corrected() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Corrected(int cedno, int xztmark, int zgtmark, int allmarker, Teacher t, Tests tests, Subject sj,
			Student s) {
		super();
		this.cedno = cedno;
		this.xztmark = xztmark;
		this.zgtmark = zgtmark;
		this.allmarker = allmarker;
		this.t = t;
		this.tests = tests;
		this.sj = sj;
		this.s = s;
	}
	public int getCedno() {
		return cedno;
	}
	public void setCedno(int cedno) {
		this.cedno = cedno;
	}
	public int getXztmark() {
		return xztmark;
	}
	public void setXztmark(int xztmark) {
		this.xztmark = xztmark;
	}
	public int getZgtmark() {
		return zgtmark;
	}
	public void setZgtmark(int zgtmark) {
		this.zgtmark = zgtmark;
	}
	public int getAllmarker() {
		return allmarker;
	}
	public void setAllmarker(int allmarker) {
		this.allmarker = allmarker;
	}
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
	public Tests getTests() {
		return tests;
	}
	public void setTests(Tests tests) {
		this.tests = tests;
	}
	public Subject getSj() {
		return sj;
	}
	public void setSj(Subject sj) {
		this.sj = sj;
	}
	public Student getS() {
		return s;
	}
	public void setS(Student s) {
		this.s = s;
	}
	
}
