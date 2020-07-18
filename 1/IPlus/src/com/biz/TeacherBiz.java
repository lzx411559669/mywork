package com.biz;

import java.util.List;

import com.entity.Teacher;


public interface TeacherBiz {
	/**
	 * ��ѯ������ʦ
	 * @param index
	 * @param size
	 * @return
	 */
public List<Teacher> findAll(Integer index,Integer size);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
public int count();
	/**
	 * ɾ����ʦ��Ϣ
	 * @param tid
	 */
public void delTeacher(int tid);
/**
 * ���ӽ�ʦ��Ϣ
 * @param t
 */
public void addTeacher(Teacher t);
/**
 * ������������ѧ��
 * @param tname
 * @return
 */
public List<Teacher> findTeacher(String tname);
/**
 * ����tid���ҽ�ʦ
 * @param tid
 * @return
 */
public Teacher findByTid(int tid);
/**
 * �޸Ľ�ʦ��Ϣ
 * @param t
 */
public void updateTeacher(Teacher t);
/**
 * 
 * @param tid
 * @param tpwd
 * @return
 */
public Teacher login(int tid,String tpwd);
/**
 * �޸Ľ�ʦ����
 * @param t
 */
public void updateTpwd(Teacher t);
}