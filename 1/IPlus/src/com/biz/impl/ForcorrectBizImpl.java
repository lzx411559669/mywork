package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.ForcorrectBiz;
import com.dao.ForcorrectDao;
import com.entity.Forcorrect;
@Component("forcorrectBiz")
public class ForcorrectBizImpl implements ForcorrectBiz {
	@Autowired
	private ForcorrectDao forcorrectDao;
	@Override
	public List<Forcorrect> show(Integer index, Integer size) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Forcorrect> list=forcorrectDao.show(map);
		return list;
	}

	@Override
	public int count() {
		int count=0;
		count=forcorrectDao.count();
		return count;
	}

	@Override
	public void add(Forcorrect f) {
		forcorrectDao.add(f);
	}

	@Override
	public Forcorrect findByfcno(int fcno) {
		Forcorrect f=forcorrectDao.findByfcno(fcno);
		return f;
	}

	@Override
	public void update(Forcorrect f) {
		forcorrectDao.update(f);
	}

	@Override
	public void del(int fcno) {
		forcorrectDao.del(fcno);
	}

	@Override
	public Forcorrect IsTest(Forcorrect f) {
		Forcorrect fc=forcorrectDao.IsTest(f);
		return fc;
	}

}
