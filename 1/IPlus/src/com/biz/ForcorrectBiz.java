package com.biz;

import java.util.List;

import com.entity.Forcorrect;

public interface ForcorrectBiz {
	/**
	 * 显示所有待批试卷
	 * @param map
	 * @return
	 */
	public List<Forcorrect> show(Integer index,Integer size);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 自动导入待批试卷
	 * @param f
	 */
	public void add(Forcorrect f);
	/**
	 * 查找对应的待批改试卷
	 * @param fcno
	 * @return
	 */
	public Forcorrect findByfcno(int fcno);
	/**
	 * 改变阅卷状态
	 * @param f
	 */
	public void update(Forcorrect f);
	/**
	 * 删除已批改试卷
	 * @param fcno
	 */
	public void del(int fcno);
	/**
	 * 查询这个学生有没有考过试
	 * @param testsno
	 * @param sid
	 * @return
	 */
	public Forcorrect IsTest(Forcorrect f);
}
