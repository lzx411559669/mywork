package com.biz;

import java.util.List;

import com.entity.Xzt;

public interface XztBiz {
	/**
	 * ��ʾѡ����
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Xzt> showxzt(Integer index,Integer size);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * ɾ����Ŀ
	 * @param xztno
	 */
	public void delXzt(int xztno);
	/**
	 * ������Ŀ
	 * @param x
	 */
	public void addXzt(Xzt x);
	/**
	 * ����ѡ����Ų�����Ŀ
	 * @param xztno
	 * @return
	 */
	public Xzt findByXztno(int xztno);
	/**
	 * �޸�ѡ����
	 * @param x
	 */
	public void updateXzt(Xzt x);
	/**
	 * ��������ģ����ѯѡ����
	 * @param xztnr
	 * @return
	 */
	public List<Xzt> findXzt(String xztnr);
	/**
	 * �������
	 * @return
	 */
	public List<Xzt> start(int suid);
}