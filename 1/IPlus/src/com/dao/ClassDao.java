package com.dao;

import java.util.List;
import java.util.Map;
import com.entity.Banji;

public interface ClassDao {
	/**
	 * 显示所有班级信息
	 * @param map
	 * @return
	 */
	public List<Banji> showAllClass(Map<String,Object> map);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 删除班级
	 * @param cid
	 */
	public void delClass(int cid);
	/**
	 * 添加班级
	 * @param cl
	 */
	public void addClass(Banji cl);
	/**
	 * 查找班级
	 */
	public List<Banji> findClass(int cid);
	/**
	 * 按班级号查找
	 * @param cid
	 * @return
	 */
	public Banji findByCid(int cid);
	/**
	 * 修改班级信息
	 * @param cl
	 */
	public void updateClass(Banji cl);
	/**
	 * 查看有多少班级
	 * @return
	 */
	public List<Banji> findCl();
}
