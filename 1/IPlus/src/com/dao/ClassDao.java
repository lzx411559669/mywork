package com.dao;

import java.util.List;
import java.util.Map;
import com.entity.Banji;

public interface ClassDao {
	/**
	 * ��ʾ���а༶��Ϣ
	 * @param map
	 * @return
	 */
	public List<Banji> showAllClass(Map<String,Object> map);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * ɾ���༶
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