package com.biz;

import java.util.List;

import com.entity.Banji;

public interface ClassBiz {
	/**
	 * 显示所有班级信息
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Banji> showAllClass(Integer index,Integer size);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 删除
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
	 * @param cid
	 * @return
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
