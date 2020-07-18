package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Subject;

public interface SubjectDao {
	/**
	 * 查询所有学科
	 * @param map
	 * @return
	 */
	public List<Subject> showAllSub(Map<String,Object> map);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 删除学科
	 * @param suid
	 */
	public void delSubject(int suid);
	/**
	 * 添加学科
	 * @param sj
	 */
	public void addSubject(Subject sj);
	/**
	 * 根据学科名查找学科
	 * @param suname
	 * @return
	 */
	public List<Subject> findSubject (String suname);
	/**
	 * 根据学科id查找学科
	 * @param suid
	 * @return
	 */
	public Subject findBySuid(int suid);
	/**
	 * 修改课程
	 * @param sj
	 */
	public void updateSubject(Subject sj);
	/**
	 * 查找学科
	 * @return
	 */
	public List<Subject> findsj();
}
