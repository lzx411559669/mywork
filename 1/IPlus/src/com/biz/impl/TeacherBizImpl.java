package com.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.biz.TeacherBiz;
import com.dao.TeacherDao;
import com.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("teacherBiz")
public class TeacherBizImpl implements TeacherBiz{
@Autowired
   private TeacherDao teacherDao;
	public List<Teacher> findAll(Integer index, Integer size) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Teacher> list=teacherDao.findAll(map);
		return list;
	}
	@Override
	public int count() {
		int count=0;
		count=teacherDao.count();
		return count;
	}
	@Override
	public void delTeacher(int tid) {
		teacherDao.delTeacher(tid);
		
	}
	@Override
	public void addTeacher(Teacher t) {
		teacherDao.addTeacher(t);
	}
	@Override
	public List<Teacher> findTeacher(String tname) {
		List<Teacher> list=teacherDao.findTeacher(tname);
		return list;
	}
	@Override
	public Teacher findByTid(int tid) {
		Teacher t=teacherDao.findByTid(tid);
		return t;
	}
	@Override
	public void updateTeacher(Teacher t) {
		teacherDao.updateTeacher(t);
	}
	@Override
	public Teacher login(int tid, String tpwd) {
		Teacher t=teacherDao.login(tid, tpwd);
		return t;
	}
	@Override
	public void updateTpwd(Teacher t) {
		teacherDao.updateTpwd(t);
	}

}
