package com.biz;

import java.util.List;

import com.entity.Zgt;

public interface ZgtBiz {
	/**
	 * ��ʾ������
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Zgt> show(Integer index,Integer size);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * ɾ��������
	 * @param zgtno
	 */
	public void delZgt(int zgtno);
	/**
	 * ����������
	 * @param z
	 */
	public void addZgt(Zgt z);
	/**
	 * ����������
	 * @param zgtno
	 * @return
	 */
	public Zgt findByZgtno(int zgtno);
	/**
	 * �޸�������
	 * @param z
	 */
	public void updateZgt(Zgt z);
	/**
	 * ����������
	 * @param zgtnr
	 * @return
	 */
	public List<Zgt> findZgt(String zgtnr);
	/**
	 * �������
	 * @return
	 */
	public List<Zgt> start(int suid);
}