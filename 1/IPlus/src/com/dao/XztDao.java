package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xzt;

public interface XztDao {
	/**
	 * 显示所有题目
	 * @param map
	 * @return
	 */
	public List<Xzt> showxzt(Map<String,Object> map); 
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 删除题目
	 * @param xztno
	 */
	public void delXzt(int xztno);
	/**
	 * 添加题目
	 * @param x
	 */
	public void addXzt(Xzt x);
	/**
	 * 根据选择题号查找题目
	 * @param xztno
	 * @return
	 */
	public Xzt findByXztno(int xztno);
	/**
	 * 修改选择题
	 * @param x
	 */
	public void updateXzt(Xzt x);
	/**
	 * 根据内容模糊查询选择题
	 * @param xztnr
	 * @return
	 */
	public List<Xzt> findXzt(String xztnr);
	/**
	 * 遍历题库
	 * @return
	 */
	public List<Xzt> start(int suid);
}
