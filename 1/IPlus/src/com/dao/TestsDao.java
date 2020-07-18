package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tests;
import com.entity.Banji;

public interface TestsDao {
	/**
	 * 显示考试安排
	 * @param map
	 * @return
	 */
	public List<Tests> show (Map<String,Object> map);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 新建考试安排
	 * @param test
	 */
	public void addTests(Tests test);
	/**
	 * 显示考试安排表
	 * @param cid
	 * @return
	 */
	public List<Tests> testList(int cid);
	/**
	 * 查找考试场次
	 * @param testsno
	 * @return
	 */
	public Tests findt(int testsno);
	/**
	 * 改变考试状态
	 * @param tests
	 */
	public void update(Tests tests);
	
}
