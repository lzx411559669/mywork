package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Corrected;

public interface CorrectedDao {
	/**
	 * ��ʾ�������ĺ���Ծ�
	 * @param map
	 * @return
	 */
	public List<Corrected> show(Map<String,Object> map);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * �Զ��������ĺ���Ծ���Ϣ
	 * @param c
	 */
	public void add(Corrected c);
	/**
	 * ��ʾ�ɼ�
	 * @return
	 */
	public List<Corrected> showmark(int sid);
}