package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zgt;

public interface ZgtDao {
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<Zgt> show(Map<String,Object> map); 
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