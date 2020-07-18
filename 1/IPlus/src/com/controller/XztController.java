package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.SubjectBiz;
import com.biz.XztBiz;
import com.entity.Subject;
import com.entity.Xzt;

@RequestMapping("/xzt.do")
@Controller
public class XztController {
	@Autowired
	private XztBiz xztBiz;
	@Autowired
	private SubjectBiz subjectBiz;
	
	@RequestMapping(params="showxzt")
	public String showxzt(ModelMap map,Integer index){
		Integer size=10;
	    if(index==null){
	    	index=1;
	    }
	    List<Xzt> list=xztBiz.showxzt(index, size);
	    List<Subject> sulist=subjectBiz.findsj();
		  map.put("sulist",sulist);
	  //¼ÆËã×ÜÒ³Êý
	      int count=xztBiz.count();
	      Integer total=count%size==0?count/size:count/size+1;
	      map.put("list",list);
	      map.put("index",index);
	      map.put("total", total);
		return "showallxzt";
	}
	@RequestMapping(params="delXzt")
	public String delXzt(Integer xztno){
		xztBiz.delXzt(xztno);
		return "redirect:xzt.do?showxzt";
	}
	@RequestMapping(params="addXzt")
	public String addXzt(ModelMap map,String xztnr,Integer val,String a,String b,String c,String d,String answer,Integer suid){
		Xzt x=new Xzt();
		x.setXztnr(xztnr);
		x.setVal(val);
		x.setA(a);
		x.setB(b);
		x.setC(c);
		x.setD(d);
		x.setAnswer(answer);
		x.getSj().setSuid(suid);
		xztBiz.addXzt(x);
		return "redirect:xzt.do?showxzt";
	}
	@RequestMapping(params="findByXztno")
	@ResponseBody
	public Xzt findByXztno(Integer xztno){
		Xzt x=xztBiz.findByXztno(xztno);
		return x;
	}
	@RequestMapping(params="updateXzt")
	public String updateXzt(ModelMap map,Integer xztno,String xztnr,Integer val,String a,String b,String c,String d,String answer,Integer suid){
		Xzt x=new Xzt();
		x.setXztno(xztno);
		x.setXztnr(xztnr);
		x.setVal(val);
		x.setA(a);
		x.setB(b);
		x.setC(c);
		x.setD(d);
		x.setAnswer(answer);
		x.getSj().setSuid(suid);
		xztBiz.updateXzt(x);
		return "redirect:xzt.do?showxzt";
	}
	@RequestMapping(params="findXzt")
	public String findXzt(ModelMap map,String xztnr){
		List<Xzt> list=xztBiz.findXzt(xztnr);
		List<Subject> sulist=subjectBiz.findsj();
		map.put("sulist",sulist);
		map.put("list", list);
		return "findxzt";
	}
}
