package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.SubjectBiz;
import com.biz.ZgtBiz;
import com.entity.Subject;
import com.entity.Zgt;

@RequestMapping("/zgt.do")
@Controller
public class ZgtController {
	@Autowired
	private ZgtBiz zgtBiz;
	@Autowired
	private SubjectBiz subjectBiz;
	
	@RequestMapping(params="show")
	public String show(ModelMap map,Integer index){
		Integer size=10;
	    if(index==null){
	    	index=1;
	    }
	    List<Zgt> list=zgtBiz.show(index, size);
	    List<Subject> sulist=subjectBiz.findsj();
		  map.put("sulist",sulist);
	  //¼ÆËã×ÜÒ³Êý
	      int count=zgtBiz.count();
	    Integer total=count%size==0?count/size:count/size+1;
	      map.put("list",list);
	      map.put("index",index);
	      map.put("total", total);
	      return "showallzgt";
	}
	@RequestMapping(params="delZgt")
	public String delZgt(Integer zgtno){
		zgtBiz.delZgt(zgtno);
		return "redirect:zgt.do?show";
	} 
	@RequestMapping(params="addZgt")
	public String addZgt(ModelMap map,String zgtnr,Integer val,String standard,Integer suid){
		Zgt z=new Zgt();
		z.setZgtnr(zgtnr);
		z.setVal(val);
		z.setStandard(standard);
		z.getSj().setSuid(suid);
		zgtBiz.addZgt(z);
		return "redirect:zgt.do?show";
	}
	@RequestMapping(params="findByZgtno")
	@ResponseBody
	public Zgt findByZgtno(Integer zgtno){
		Zgt z=zgtBiz.findByZgtno(zgtno);
		return z;
	}
	@RequestMapping(params="updateZgt")
	public String updateZgt(ModelMap map,Integer zgtno,String zgtnr,Integer val,String standard,Integer suid){
		Zgt z=new Zgt();
		z.setZgtno(zgtno);
		z.setZgtnr(zgtnr);
		z.setVal(val);
		z.setStandard(standard);
		z.getSj().setSuid(suid);
		zgtBiz.updateZgt(z);
		return "redirect:zgt.do?show";
	}
	@RequestMapping(params="findZgt")
	public String findZgt(ModelMap map,String zgtnr){
		List<Zgt> list=zgtBiz.findZgt(zgtnr);
		map.put("list",list);
		List<Subject> sulist=subjectBiz.findsj();
		map.put("sulist",sulist);
		return "findzgt";
	}
}
