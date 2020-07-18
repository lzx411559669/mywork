package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ClassBiz;
import com.biz.ForcorrectBiz;
import com.biz.SubjectBiz;
import com.biz.TestsBiz;
import com.biz.XztBiz;
import com.biz.ZgtBiz;
import com.entity.Tests;
import com.entity.Xzt;
import com.entity.Zgt;
import com.entity.Banji;
import com.entity.Forcorrect;
import com.entity.Subject;

@RequestMapping("/tests.do")
@Controller
public class TestsController {
	@Autowired
	private TestsBiz testsBiz;
	@Autowired
	private ClassBiz classBiz;
	@Autowired
	private XztBiz xztBiz;
	@Autowired
	private ZgtBiz zgtBiz;
	@Autowired
	private SubjectBiz subjectBiz;
	@Autowired
	private ForcorrectBiz forcorrectBiz;
	
	@RequestMapping(params="show")
	public String show(ModelMap map,Integer index){
		Integer size=10;
	    if(index==null){
	    	index=1;
	    }
		List<Tests> list=testsBiz.show(index, size);
		List<Banji> clist=classBiz.findCl();
		List<Subject> sulist=subjectBiz.findsj();
		map.put("sulist",sulist);
		int count=testsBiz.count();
	    Integer total=count%size==0?count/size:count/size+1;
	    map.put("list",list);
	    map.put("clist",clist);
	    map.put("index",index);
	    map.put("total", total);
		return "showalltests";
	}
	@RequestMapping(params="addTests")
	public String addTests(ModelMap map,Integer cid,Integer suid){
		Tests test=new Tests();
		test.getCl().setCid(cid);
		test.getSj().setSuid(suid);
		testsBiz.addTests(test);
		return "redirect:tests.do?show";
	}
	@RequestMapping(params="testList")
	public String testList(ModelMap map,Integer cid,Integer sid){
		List<Tests> list=testsBiz.testList(cid);
		List<Tests> slist=new ArrayList<Tests>();
		int testsno=0;
		Forcorrect f1=new Forcorrect();
		for(int i=0;i<(list.size());i++){
			testsno=list.get(i).getTestsno();
			f1.setTestsno(testsno);
			f1.getStu().setSid(sid);
			Forcorrect f2=forcorrectBiz.IsTest(f1);
			if(f2!=null){
				if(f2.getZgtda1()==null){
					slist.add(list.get(i));
				}else{
					list.get(i).setCondition(2);
					slist.add(list.get(i));
				}
			}else{
				slist.add(list.get(i));
			}
		}
		map.put("slist", slist);
		return "studenttest";
	}
	@RequestMapping(params="start")
	public String start(ModelMap map,Integer suid,Integer testsno){
		List<Xzt> xlist=xztBiz.start(suid);
		List<Zgt> zlist=zgtBiz.start(suid);
		Tests t=testsBiz.findt(testsno);
		Subject sj=subjectBiz.findBySuid(suid);
		map.put("t", t);
		map.put("sj", sj);
		int count1=5;
		int count2=2;
		List<Xzt> t1list=new ArrayList<Xzt>();
		List<Zgt> t2list=new ArrayList<Zgt>();
		for(int i=0;i<count1;i++){
			t1list.add(xlist.get((int) Math.floor(Math.random()*(xlist.size()))));
		}
		for(int j=0;j<count2;j++){
			t2list.add(zlist.get((int) Math.floor(Math.random()*(zlist.size()))));
		}
		Xzt x1=t1list.get(0);
		Xzt x2=t1list.get(1);
		Xzt x3=t1list.get(2);
		Xzt x4=t1list.get(3);
		Xzt x5=t1list.get(4);
		Zgt z1=t2list.get(0);
		Zgt z2=t2list.get(1);
		map.put("x1", x1);
		map.put("x2", x2);
		map.put("x3", x3);
		map.put("x4", x4);
		map.put("x5", x5);
		map.put("z1", z1);
		map.put("z2", z2);
		return "starttests";
	}
	@RequestMapping(params="check")
	@ResponseBody
	public Forcorrect check(Integer suid,Integer testsno,Integer zgt1no,Integer zgt2no,String zgtda1,String zgtda2,Integer xzt1no,Integer xzt2no,Integer xzt3no,Integer xzt4no,Integer xzt5no,String xzt1c,String xzt2c,String xzt3c,String xzt4c,String xzt5c,Integer sid){
		int mark=0;
		Xzt x1=xztBiz.findByXztno(xzt1no);
		if(x1.getAnswer().equals(xzt1c)){
			mark+=x1.getVal();
		}
		Xzt x2=xztBiz.findByXztno(xzt2no);
		if(x2.getAnswer().equals(xzt2c)){
			mark+=x2.getVal();
		}
		Xzt x3=xztBiz.findByXztno(xzt3no);
		if(x3.getAnswer().equals(xzt3c)){
			mark+=x3.getVal();
		}
		Xzt x4=xztBiz.findByXztno(xzt4no);
		if(x4.getAnswer().equals(xzt4c)){
			mark+=x4.getVal();
		}
		Xzt x5=xztBiz.findByXztno(xzt5no);
		if(x5.getAnswer().equals(xzt5c)){
			mark+=x5.getVal();;
		}
		Forcorrect f=new Forcorrect();
		f.setXztmark(mark);
		f.setTestsno(testsno);
		f.setZgtno1(zgt1no);
		f.setZgtda1(zgtda1);
		f.setZgtno2(zgt2no);
		f.setZgtda2(zgtda2);
		f.getStu().setSid(sid);
		f.getSj().setSuid(suid);
		forcorrectBiz.add(f);
		return f;
		
	}
}
