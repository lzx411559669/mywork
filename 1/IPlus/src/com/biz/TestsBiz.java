package com.biz;

import java.util.List;

import com.entity.Banji;
import com.entity.Tests;

public interface TestsBiz {
	/**
	 * ��ʾ���԰���
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Tests> show(Integer index,Integer size);
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