package com.entity;

public class Xzt {
	private int xztno;
	private String xztnr; 
	private int val;
	private String A;
	private String B;
	private String C;
	private String D;
	private String answer;
	private Subject sj=new Subject();
	public Xzt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xzt(int xztno, String xztnr, int val, String a, String b, String c, String d, String answer, Subject sj) {
		super();
		this.xztno = xztno;
		this.xztnr = xztnr;
		this.val = val;
		A = a;
		B = b;
		C = c;
		D = d;
		this.answer = answer;
		this.sj = sj;
	}
	public int getXztno() {
		return xztno;
	}
	public void setXztno(int xztno) {
		this.xztno = xztno;
	}
	public String getXztnr() {
		return xztnr;
	}
	public void setXztnr(String xztnr) {
		this.xztnr = xztnr;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Subject getSj() {
		return sj;
	}
	public void setSj(Subject sj) {
		this.sj = sj;
	}
	
}
