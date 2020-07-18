package com.biz;

import java.util.List;

import com.entity.Banji;

public interface ClassBiz {
	/**
	 * ��ʾ���а༶��Ϣ
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Banji> showAllClass(Integer index,Integer size);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * ɾ��
	 * @param cid
	 */
	public void delClass(int cid);
	/**
	 * ���Ӱ༶
	 * @param cl
	 */
	public void addClass(Banji cl);
	/**
	 * ���Ұ༶
	 * @param cid
	 * @return
	 */
	public List<Banji> findClass(int cid);
	/**
	 * ���༶�Ų���
	 * @param cid
	 * @return
	 */
	public Banji findByCid(int cid);
	/**
	 * �޸İ༶��Ϣ
	 * @param cl
	 */
	public void updateClass(Banji cl);
	/**
	 * �鿴�ж��ٰ༶
	 * @return
	 */
	public List<Banji> findCl();
}