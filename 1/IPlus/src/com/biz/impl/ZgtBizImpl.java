package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.ZgtBiz;
import com.dao.ZgtDao;
import com.entity.Zgt;
@Component("zgtBiz")
public class ZgtBizImpl implements ZgtBiz {
	@Autowired
	private ZgtDao zgtDao;
	@Override
	public List<Zgt> show(Integer index, Integer size) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Zgt> list=zgtDao.show(map);
		return list;
	}

	@Override
	public int count() {
		int count=0;
		count=zgtDao.count();
		return count;
	}

	@Override
	public void delZgt(int zgtno) {
		zgtDao.delZgt(zgtno);
	}

	@Override
	public void addZgt(Zgt z) {
		zgtDao.addZgt(z);
	}

	@Override
	public Zgt findByZgtno(int zgtno) {
		Zgt z=zgtDao.findByZgtno(zgtno);
		return z;
	}

	@Override
	public void updateZgt(Zgt z) {
		zgtDao.updateZgt(z);
	}

	@Override
	public List<Zgt> findZgt(String zgtnr) {
		List<Zgt> list=zgtDao.findZgt(zgtnr);
		return list;
	}

	@Override
	public List<Zgt> start(int suid) {
		List<Zgt> list=zgtDao.start(suid);
		return list;
	}

}
