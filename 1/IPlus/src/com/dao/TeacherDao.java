package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Teacher;


public interface TeacherDao {
	/**
	 * ��ѯ������ʦ
	 * @param map
	 * @return
	 */
public List<Teacher> findAll(Map<String,Object> map);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
public int count();
	/**
	 * ɾ����ʦ��Ϣ
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
	 * ��ʦ��¼
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