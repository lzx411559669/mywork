package com.biz;

import java.util.List;

import com.entity.Corrected;

public interface CorrectedBiz {

	/**
	 * ��ʾ�������ĺ���Ծ�
	 * @param map
	 * @return
	 */
	public List<Corrected> show(Integer index,Integer size);
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