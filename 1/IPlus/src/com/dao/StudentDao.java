package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Student;

public interface StudentDao {
	/**
	 * ��ʾ����ѧ����Ϣ
	 * @param map
	 * @return
	 */
	public List<Student> showAllStu(Map<String,Object> map);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * ɾ��ѧ����Ϣ
	 * @param sid
	 */
	public void delStudent(int sid);
	/**
	 * ����ѧ��
	 * @param stu
	 */
	public void addStudent(Student stu);
	/**
	 * ������������ѧ��
	 * @param sname
	 * @return
	 */
	public List<Student> findStudent(String sname);
	/**
	 * ����sid����ѧ��
	 * @param sid
	 * @return
	 */
	public Student findBySid(int sid);
	/**
	 * �޸�ѧ����Ϣ
	 * @param stu
	 */
	public void updateStudent(Student stu);
	/**
	 * ѧ����¼
	 * @param sid
	 * @param apwd
	 * @return
	 */
	public Student login(int sid,String spwd);
	/**
	 * �޸�����
	 * @param stu
	 */
	public void updateSpwd(Student stu);
	
}