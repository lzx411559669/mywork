package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ClassBiz;
import com.entity.Banji;
@RequestMapping("/class.do")
@Controller
public class ClassController {
	@Autowired
	private ClassBiz classBiz;
	@RequestMapping(params="showallcl")
	public String findAll(ModelMap map,Integer index){
		    Integer size=10;
			    if(index==null){
			    	index=1;
			    }
			List<Banji> list=classBiz.showAllClass(index, size);
			//¼ÆËã×ÜÒ³Êý
			int count=classBiz.count();
			Integer total=count%size==0?count/size:count/size+1;
			map.put("list",list);
			map.put("index",index);
			map.put("total", total);
			return "showallclass";
		}
	@RequestMapping(params="delClass")
	public String delClass(Integer cid){
		classBiz.delClass(cid);
		return "redirect:class.do?showallcl";
	}
	@RequestMapping(params="addClass")
	public String addClass(ModelMap map,Integer num){
		Banji cl=new Banji();
		cl.setNum(num);
//		cl.setGrade(grade);
		classBiz.addClass(cl);
		
		return "redirect:class.do?showallcl";
		}
	@RequestMapping(params="findClass")
	public String findClass(ModelMap map,Integer cid){
		List<Banji> list=classBiz.findClass(cid);
		map.put("list", list);
		return "findclass";
	}
	@RequestMapping(params="findByCid")
	@ResponseBody
	public Banji findByCid(int cid){
		Banji cl=classBiz.findByCid(cid);
		return cl;
	}
	@RequestMapping(params="updateClass")
	public String updateClass(ModelMap map,Integer cid,Integer num){
		Banji cl=new Banji();
		cl.setNum(num);
		cl.setCid(cid);
		classBiz.updateClass(cl);
		return "redirect:class.do?showallcl";
		}
}
