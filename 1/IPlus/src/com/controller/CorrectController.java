package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ClassBiz;
import com.biz.CorrectedBiz;
import com.biz.ForcorrectBiz;
import com.biz.SubjectBiz;
import com.biz.TeacherBiz;
import com.biz.ZgtBiz;
import com.entity.Banji;
import com.entity.Corrected;
import com.entity.Forcorrect;
import com.entity.Subject;
import com.entity.Teacher;
import com.entity.Zgt;

@RequestMapping("/correct.do")
@Controller
public class CorrectController {
	@Autowired
	private ForcorrectBiz forcorrectBiz;
	@Autowired
	private ClassBiz classBiz;
	@Autowired
	private SubjectBiz subjectBiz;
	@Autowired
	private ZgtBiz zgtBiz;
	@Autowired
	private TeacherBiz teacherBiz;
	@Autowired
	private CorrectedBiz correctedBiz;
	
	@RequestMapping(params="show")
	public String show(ModelMap map,Integer index){
		Integer size=10;
	    if(index==null){
	    	index=1;
	    }
	    List<Forcorrect> list=forcorrectBiz.show(index, size);
	    List<Banji> clist=classBiz.findCl();
	    map.put("clist",clist);
		List<Subject> sulist=subjectBiz.findsj();
		map.put("sulist",sulist);
	    int count=forcorrectBiz.count();
	    Integer total=count%size==0?count/size:count/size+1;
	    map.put("list",list);
	    map.put("index",index);
	    map.put("total", total);
	    return "showallforcorrect";
	}
	@RequestMapping(params="correct")
	public String correct(ModelMap map,int fcno,int tid){
		int zgtno1=0;
		int zgtno2=0;
		Teacher t=teacherBiz.findByTid(tid);
		map.put("t", t);
		Forcorrect f=forcorrectBiz.findByfcno(fcno);
		map.put("f", f);
		zgtno1=f.getZgtno1();
		zgtno2=f.getZgtno2();
		Zgt z1=zgtBiz.findByZgtno(zgtno1);
		Zgt z2=zgtBiz.findByZgtno(zgtno2);
		map.put("z1",z1);
		map.put("z2",z2);
		return "startcorrect";
	}
	@RequestMapping(params="pingfen")
	@ResponseBody
	public Corrected pingfen(Integer fcno,Integer xztmark,Integer pf1,Integer pf2,Integer tid,Integer sid,Integer suid,Integer testsno){
		int zgtmark=0;
		int allmark=0;
		zgtmark=pf1+pf2;
		allmark=zgtmark+xztmark;
		Corrected c=new Corrected();
		c.setXztmark(xztmark);
		c.setZgtmark(zgtmark);
		c.setAllmarker(allmark);
		c.getT().setTid(tid);
		c.getS().setSid(sid);
		c.getSj().setSuid(suid);
		c.getTests().setTestsno(testsno);
		correctedBiz.add(c);
		Forcorrect f=new Forcorrect();
		f.setFcno(fcno);
		forcorrectBiz.update(f);
		return c;
	}
	@RequestMapping(params="del")
	public String del(Integer fcno){
		forcorrectBiz.del(fcno);
		return "redirect:correct.do?show";
	}
}
