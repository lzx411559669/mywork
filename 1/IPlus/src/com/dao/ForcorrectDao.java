package com.dao;

import java.util.Map;

import com.entity.Forcorrect;

import java.util.List;

public interface ForcorrectDao {
	/**
	 * ��ʾ���д����Ծ�
	 * @param map
	 * @return
	 */
	public List<Forcorrect> show(Map<String,Object> map);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * �Զ���������Ծ�
	 * @param f
	 */
	public void add(Forcorrect f);
	/**
	 * ���Ҷ�Ӧ�Ĵ������Ծ�
	 * @param fcno
	 * @return
	 */
	public Forcorrect findByfcno(int fcno);
	/**
	 * �ı��ľ�״̬
	 * @param f
	 */
	public void update(Forcorrect f);
	/**
	 * ɾ���������Ծ�
	 * @param fcno
	 */
	public void del(int fcno);
	/**
	 * ��ѯ���ѧ����û�п�����
	 * @param testsno
	 * @param sid
	 * @return
	 */
	public Forcorrect IsTest(Forcorrect f);
}