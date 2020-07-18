package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.CorrectedBiz;
import com.dao.CorrectedDao;
import com.entity.Corrected;
@Component("correctedBiz")
public class CorrectedBizImpl implements CorrectedBiz {
	@Autowired
	private CorrectedDao correctedDao;
	@Override
	public List<Corrected> show(Integer index, Integer size) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Corrected> list=correctedDao.show(map);
		return list;
	}

	@Override
	public int count() {
		int count=0;
		count=correctedDao.count();
		return count;
	}

	@Override
	public void add(Corrected c) {
		correctedDao.add(c);
	}

	@Override
	public List<Corrected> showmark(int sid) {
		List<Corrected> list=correctedDao.showmark(sid);
		return list;
	}

}
