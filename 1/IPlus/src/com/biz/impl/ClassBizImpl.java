package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.ClassBiz;
import com.dao.ClassDao;
import com.entity.Banji;
@Component("classBiz")
public class ClassBizImpl implements ClassBiz {
	@Autowired
	private ClassDao classDao;
	@Override
	public List<Banji> showAllClass(Integer index, Integer size) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Banji> list=classDao.showAllClass(map);
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count=0;
		count=classDao.count();
		return count;
	}

	@Override
	public void delClass(int cid) {
		classDao.delClass(cid);
	}

	@Override
	public void addClass(Banji cl) {
		classDao.addClass(cl);
	}

	@Override
	public List<Banji> findClass(int cid) {
		List<Banji> cl=classDao.findClass(cid);
		return cl;
	}

	@Override
	public void updateClass(Banji cl) {
		classDao.updateClass(cl);
	}

	@Override
	public Banji findByCid(int cid) {
		Banji cl=classDao.findByCid(cid);
		return cl;
	}

	@Override
	public List<Banji> findCl() {
		List<Banji> list=classDao.findCl();
		return list;
	}
}
