package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.SubjectBiz;
import com.entity.Subject;

@RequestMapping("/subject.do")
@Controller
public class SubjectController {
	@Autowired
	private SubjectBiz subjectBiz;
	@RequestMapping(params="showallsub")
	public String findAll(ModelMap map,Integer index){
		    Integer size=10;
			    if(index==null){
			    	index=1;
			    }
			List<Subject> list=subjectBiz.showAllSub(index, size);
			//¼ÆËã×ÜÒ³Êý
			int count=subjectBiz.count();
			Integer total=count%size==0?count/size:count/size+1;
			map.put("list",list);
			map.put("index",index);
			map.put("total", total);
			return "showallsubject";
		}
	@RequestMapping(params="delSubject")
	public String delSubject(Integer suid){
		subjectBiz.delSubject(suid);
		return "redirect:subject.do?showallsub";
	}
	@RequestMapping(params="addSubject")
	public String addSubject(ModelMap map,String suname){
		Subject sj=new Subject();
		sj.setSuname(suname);
		subjectBiz.addSubject(sj);
		return "redirect:subject.do?showallsub";
	}
	@RequestMapping(params="findSubject")
	public String findSubject(ModelMap map,String suname){	
	    List<Subject> list=subjectBiz.findSubject(suname);
		map.put("list",list);
		return "findsubject";
	}
	@RequestMapping(params="findBySuid")
	@ResponseBody
	public Subject findBySuid(Integer suid){
		Subject sj=subjectBiz.findBySuid(suid);
		return sj;
		}
	@RequestMapping(params="updateSubject")
	public String updateSubject(ModelMap map,Integer suid,String suname){
		Subject sj=new Subject();
		sj.setSuid(suid);
		sj.setSuname(suname);
		subjectBiz.updateSubject(sj);
		return "redirect:subject.do?showallsub";
	}
}
