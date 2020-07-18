package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.TestsBiz;
import com.dao.TestsDao;
import com.entity.Banji;
import com.entity.Tests;
@Component("testsBiz")
public class TestsBizImpl implements TestsBiz {
	@Autowired
	private TestsDao testsDao;
	@Override
	public List<Tests> show(Integer index, Integer size) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Tests> list=testsDao.show(map);
		return list;
	}

	@Override
	public int count() {
		int count=0;
		count=testsDao.count();
		return count;
	}

	@Override
	public void addTests(Tests test) {
		testsDao.addTests(test);
	}

	@Override
	public List<Tests> testList(int cid) {
		List<Tests> list=testsDao.testList(cid);
		return list;
	}

	@Override
	public Tests findt(int testsno) {
		Tests t=testsDao.findt(testsno);
		return t;
	}

	@Override
	public void update(Tests tests) {
		testsDao.update(tests);
	}

}
