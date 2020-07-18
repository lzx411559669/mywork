package com.biz;

import java.util.List;

import com.entity.Teacher;


public interface TeacherBiz {
	/**
	 * 查询所有老师
	 * @param index
	 * @param size
	 * @return
	 */
public List<Teacher> findAll(Integer index,Integer size);
	/**
	 * 返回总记录数
	 * @return
	 */
public int count();
	/**
	 * 删除教师信息
	 * @param tid
	 */
public void delTeacher(int tid);
/**
 * 添加教师信息
 * @param t
 */
public void addTeacher(Teacher t);
/**
 * 根据姓名查找学生
 * @param tname
 * @return
 */
public List<Teacher> findTeacher(String tname);
/**
 * 根据tid查找教师
 * @param tid
 * @return
 */
public Teacher findByTid(int tid);
/**
 * 修改教师信息
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
 * 修改教师密码
 * @param t
 */
public void updateTpwd(Teacher t);
}
