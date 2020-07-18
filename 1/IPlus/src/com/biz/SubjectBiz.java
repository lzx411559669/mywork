package com.biz;

import java.util.List;
import java.util.Map;

import com.entity.Subject;

public interface SubjectBiz {
	/**
	 * ��ѯ����ѧ��
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Subject> showAllSub(Integer index,Integer size);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * ɾ��ѧ��
	 * @param suid
	 */
	public void delSubject(int suid);
	/**
	 * ����ѧ��
	 * @param sj
	 */
	public void addSubject(Subject sj);
	/**
	 * ����ѧ��������ѧ��
	 * @param suname
	 * @return
	 */
	public List<Subject> findSubject (String suname);
	/**
	 * ����ѧ��id����ѧ��
	 * @param suid
	 * @return
	 */
	public Subject findBySuid(int suid);
	/**
	 * �޸Ŀγ�
	 * @param sj
	 */
	public void updateSubject(Subject sj);
	/**
	 * ����ѧ��
	 * @return
	 */
	public List<Subject> findsj();
}