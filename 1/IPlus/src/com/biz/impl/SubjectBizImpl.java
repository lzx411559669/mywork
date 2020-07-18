package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.SubjectBiz;
import com.dao.SubjectDao;
import com.entity.Subject;
@Component("subjectBiz")
public class SubjectBizImpl implements SubjectBiz {
	@Autowired
	private SubjectDao subjectDao;
	@Override
	public List<Subject> showAllSub(Integer index, Integer size) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Subject> list=subjectDao.showAllSub(map);
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count=0;
		count=subjectDao.count();
		return count;
	}

	@Override
	public void delSubject(int suid) {
		subjectDao.delSubject(suid);
	}

	@Override
	public void addSubject(Subject sj) {
		subjectDao.addSubject(sj);
	}

	@Override
	public List<Subject> findSubject(String suname) {
		List<Subject> list=subjectDao.findSubject(suname);
		return list;
	}
	
	@Override
	public Subject findBySuid(int suid) {
		Subject sj=subjectDao.findBySuid(suid);
		return sj;
	}

	@Override
	public void updateSubject(Subject sj) {
		subjectDao.updateSubject(sj);
	}

	@Override
	public List<Subject> findsj() {
		List<Subject> list=subjectDao.findsj();
		return list;
	}

}
