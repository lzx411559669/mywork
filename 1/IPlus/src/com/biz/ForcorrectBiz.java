package com.biz;

import java.util.List;

import com.entity.Forcorrect;

public interface ForcorrectBiz {
	/**
	 * ��ʾ���д����Ծ�
	 * @param map
	 * @return
	 */
	public List<Forcorrect> show(Integer index,Integer size);
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