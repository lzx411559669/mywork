package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ClassBiz;
import com.biz.CorrectedBiz;
import com.biz.StudentBiz;
import com.entity.Banji;
import com.entity.Corrected;
import com.entity.Student;

@RequestMapping("/student.do")
@Controller
public class StudentController {
	@Autowired
	private StudentBiz studentBiz;
	@Autowired
	private ClassBiz classBiz;
	@Autowired
	private CorrectedBiz correctedBiz;
	
	@RequestMapping(params="showallstu")
	public String findAll(ModelMap map,Integer index){
		    Integer size=10;
			    if(index==null){
			    	index=1;
			    }
			List<Student> list=studentBiz.showAllStu(index, size);
			List<Banji> clist=classBiz.findCl();
			//¼ÆËã×ÜÒ³Êý
			int count=studentBiz.count();
			Integer total=count%size==0?count/size:count/size+1;
			map.put("list",list);
			map.put("clist",clist);
			map.put("index",index);
			map.put("total", total);
			return "showallstudent";
		}
	@RequestMapping(params="delStudent")
	public String delStudent(Integer sid){
		studentBiz.delStudent(sid);
		return "redirect:student.do?showallstu";
		}
	@RequestMapping(params="addStudent")
	public String addStudent(ModelMap map,String spwd,String sname,String sgender,Integer cid){
		Student stu=new Student();
		stu.setSname(sname);
		stu.setSpwd(spwd);
		stu.getCl().setCid(cid);
		stu.setSgender(sgender);
		studentBiz.addStudent(stu);
		return "redirect:student.do?showallstu";
		}
	@RequestMapping(params="findStudent")
	public String findStudent(ModelMap map,String sname){
		List<Student> list=studentBiz.findStudent(sname);
		List<Banji> clist=classBiz.findCl();
		map.put("clist",clist);
		map.put("list", list);
		return "findstudent";
		}
	@RequestMapping(params="findBySid")
	@ResponseBody
	public Student findBySid(int sid){
		Student stu=studentBiz.findBySid(sid);
		return stu;
	}
	@RequestMapping(params="updateStudent")
	public String updateStudent(ModelMap map,Integer sid,String spwd,String sname,String sgender,Integer cid){
		Student stu=new Student();
		stu.setSid(sid);
		stu.setSname(sname);
		stu.setSpwd(spwd);
		stu.getCl().setCid(cid);
		stu.setSgender(sgender);
		studentBiz.updateStudent(stu);
		return "redirect:student.do?showallstu";
	}
	@RequestMapping(params="login")
	@ResponseBody
	public Student login(HttpServletRequest request, HttpServletResponse response,Integer sid,String spwd){
		Student stu=studentBiz.login(sid, spwd);
		HttpSession session=request.getSession();
		session.setAttribute("stu", stu);
		return stu;
	}
	@RequestMapping(params="updateSpwd")
	public String updateSpwd(ModelMap map,Integer sid,String spwd){
		Student stu=new Student();
		stu.setSid(sid);
		stu.setSpwd(spwd);
		studentBiz.updateSpwd(stu);
		return "studentlogin";
	}
	@RequestMapping(params="showmark")
	public String showmark (ModelMap map,int sid){
		List<Corrected> list=correctedBiz.showmark(sid);
		map.put("list", list);
		return "studentmark";
	}
	
}
