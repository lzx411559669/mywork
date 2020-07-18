package com.entity;

public class Zgt {
	private int zgtno; 
	private String zgtnr; 
	private int val;
	private String standard;
	private Subject sj=new Subject();
	public Zgt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Zgt(int zgtno, String zgtnr, int val, String standard, Subject sj) {
		super();
		this.zgtno = zgtno;
		this.zgtnr = zgtnr;
		this.val = val;
		this.standard = standard;
		this.sj = sj;
	}
	public int getZgtno() {
		return zgtno;
	}
	public void setZgtno(int zgtno) {
		this.zgtno = zgtno;
	}
	public String getZgtnr() {
		return zgtnr;
	}
	public void setZgtnr(String zgtnr) {
		this.zgtnr = zgtnr;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Subject getSj() {
		return sj;
	}
	public void setSj(Subject sj) {
		this.sj = sj;
	}
	
}
