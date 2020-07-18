package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tests;
import com.entity.Banji;

public interface TestsDao {
	/**
	 * ��ʾ���԰���
	 * @param map
	 * @return
	 */
	public List<Tests> show (Map<String,Object> map);
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int count();
	/**
	 * �½����԰���
	 * @param test
	 */
	public void addTests(Tests test);
	/**
	 * ��ʾ���԰��ű�
	 * @param cid
	 * @return
	 */
	public List<Tests> testList(int cid);
	/**
	 * ���ҿ��Գ���
	 * @param testsno
	 * @return
	 */
	public Tests findt(int testsno);
	/**
	 * �ı俼��״̬
	 * @param tests
	 */
	public void update(Tests tests);
	
}