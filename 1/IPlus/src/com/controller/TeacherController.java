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
import com.biz.SubjectBiz;
import com.biz.TeacherBiz;
import com.entity.Banji;
import com.entity.Subject;
import com.entity.Teacher;


@RequestMapping("/teacher.do")
@Controller
public class TeacherController {
	@Autowired
	private TeacherBiz teacherBiz;
	@Autowired
	private ClassBiz classBiz;
	@Autowired
	private SubjectBiz subjectBiz;
	@RequestMapping(params="show")
	public String findAll(ModelMap map,Integer index){
		          Integer size=10;
				    if(index==null){
				    	index=1;
				    }
		      List<Teacher> list=teacherBiz.findAll(index, size);
		      List<Banji> clist=classBiz.findCl();
			  map.put("clist",clist);
			  List<Subject> sulist=subjectBiz.findsj();
			  map.put("sulist",sulist);
		    //¼ÆËã×ÜÒ³Êý
		      int count=teacherBiz.count();
			  Integer total=count%size==0?count/size:count/size+1;
		      map.put("list",list);
		      map.put("index",index);
		      map.put("total", total);
		      return "showallteacher";
	}
	@RequestMapping(params="delTeacher")
	public String delTeacher(Integer tid){
		teacherBiz.delTeacher(tid);
		return "redirect:teacher.do?show";
	}
	@RequestMapping(params="addTeacher")
	public String addTeacher(ModelMap map,String tname,String tpwd,String tgender,Integer cid,Integer suid){
		Teacher t=new Teacher();
		t.setTname(tname);
		t.setTpwd(tpwd);
		t.setTgender(tgender);
		t.getCl().setCid(cid);
		t.getSj().setSuid(suid);
		teacherBiz.addTeacher(t);
		return "redirect:teacher.do?show";
	}
	@RequestMapping(params="findTeacher")
	public String findTeacher(ModelMap map,String tname){
		List<Teacher> list=teacherBiz.findTeacher(tname);
		List<Banji> clist=classBiz.findCl();
		map.put("clist",clist);
		List<Subject> sulist=subjectBiz.findsj();
		map.put("sulist",sulist);
		map.put("list", list);
		return "findteacher";
		}
	@RequestMapping(params="findByTid")
	@ResponseBody
	public Teacher findByTid(int tid){
		Teacher t=teacherBiz.findByTid(tid);
		return t;
	}
	@RequestMapping(params="updateTeacher")
	public String updateTeacher(ModelMap map,Integer tid,String tname,String tpwd,String tgender,Integer cid,Integer suid){
		Teacher t=new Teacher();
		t.setTid(tid);
		t.setTname(tname);
		t.setTpwd(tpwd);
		t.setTgender(tgender);
		t.getCl().setCid(cid);
		t.getSj().setSuid(suid);
		teacherBiz.updateTeacher(t);
		return "redirect:teacher.do?show";
	}
	
	@RequestMapping(params="login")
	@ResponseBody
	public Teacher login(HttpServletRequest request, HttpServletResponse response,Integer tid,String tpwd){
		Teacher t=teacherBiz.login(tid, tpwd);
		HttpSession session=request.getSession();
		session.setAttribute("t", t);
		return t;
	}
	
	@RequestMapping(params="updateTpwd")
	public String updateTpwd(ModelMap map,Integer tid,String tpwd){
		Teacher t=new Teacher();
		t.setTid(tid);
		t.setTpwd(tpwd);
		teacherBiz.updateTpwd(t);
		return "teacherlogin";
	}
}
