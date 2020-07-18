package com.biz;

import java.util.List;

import com.entity.Student;

public interface StudentBiz {
	/**
	 * 显示所有学生信息
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Student> showAllStu(Integer index,Integer size);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 删除学生信息
	 * @param sid
	 */
	public void delStudent(int sid);
	/**
	 * 添加学生
	 * @param stu
	 */
	public void addStudent(Student stu);
	/**
	 * 根据姓名查找学生
	 * @param sname
	 * @return
	 */
	public List<Student> findStudent(String sname);
	/**
	 * 根据sid查找学生
	 * @param sid
	 * @return
	 */
	public Student findBySid(int sid);
	/**
	 * 修改学生信息
	 * @param stu
	 */
	public void updateStudent(Student stu);
	/**
	 * 学生登录
	 * @param sid
	 * @param apwd
	 * @return
	 */
	public Student login(int sid,String spwd);
	/**
	 * 修改密码
	 * @param stu
	 */
	public void updateSpwd(Student stu);
}
