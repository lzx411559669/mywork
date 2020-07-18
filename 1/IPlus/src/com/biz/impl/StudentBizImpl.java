package com.biz.impl;

import java.util.List;

import com.biz.StudentBiz;
import com.dao.StudentDao;
import com.entity.Student;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("studentBiz")
public class StudentBizImpl implements StudentBiz {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> showAllStu(Integer index, Integer size) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("index",index);
		map.put("size",size);
		List<Student> list=studentDao.showAllStu(map);
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count=0;
		count=studentDao.count();
		return count;
	}

	@Override
	public void delStudent(int sid) {
		studentDao.delStudent(sid);
	}

	@Override
	public void addStudent(Student stu) {
		studentDao.addStudent(stu);
	}

	@Override
	public List<Student> findStudent(String sname) {
		List<Student> list=studentDao.findStudent(sname);
		return list;
	}

	@Override
	public Student findBySid(int sid) {
		Student stu=studentDao.findBySid(sid);
		return stu;
	}

	@Override
	public void updateStudent(Student stu) {
		studentDao.updateStudent(stu);
	}

	@Override
	public Student login(int sid, String spwd) {
		Student stu=studentDao.login(sid, spwd);
		return stu;
	}

	@Override
	public void updateSpwd(Student stu) {
		studentDao.updateSpwd(stu);
	}
	

}
