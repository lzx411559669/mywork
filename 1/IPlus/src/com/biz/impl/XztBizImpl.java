package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.XztBiz;
import com.dao.XztDao;
import com.entity.Xzt;
@Component("xztBiz")
public class XztBizImpl implements XztBiz {
	@Autowired
	private XztDao xztDao;
	@Override
	public List<Xzt> showxzt(Integer index, Integer size) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Xzt> list=xztDao.showxzt(map);
		return list;
	}

	@Override
	public int count() {
		int count=0;
		count=xztDao.count();	
		return count;
	}

	@Override
	public void delXzt(int xztno) {
		xztDao.delXzt(xztno);
	}

	@Override
	public void addXzt(Xzt x) {
		xztDao.addXzt(x);
	}

	@Override
	public Xzt findByXztno(int xztno) {
		Xzt x=xztDao.findByXztno(xztno);
		return x;
	}

	@Override
	public void updateXzt(Xzt x) {
		xztDao.updateXzt(x);
	}

	@Override
	public List<Xzt> findXzt(String xztnr) {
		List<Xzt> list=xztDao.findXzt(xztnr);
		return list;
	}

	@Override
	public List<Xzt> start(int suid) {
		List<Xzt> list=xztDao.start(suid);
		return list;
	}


}
