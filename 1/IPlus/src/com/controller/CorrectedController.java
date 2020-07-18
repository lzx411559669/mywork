package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.CorrectedBiz;
import com.entity.Corrected;

@RequestMapping("/corrected.do")
@Controller
public class CorrectedController {
	@Autowired
	private CorrectedBiz correctedBiz;
	@RequestMapping(params="show")
	public String show(ModelMap map,Integer index){
		Integer size=10;
	    if(index==null){
	    	index=1;
	    }
	    List<Corrected> list=correctedBiz.show(index, size);
	    int count=correctedBiz.count();
	    Integer total=count%size==0?count/size:count/size+1;
	    map.put("list",list);
	    map.put("index",index);
	    map.put("total", total);
	    return "showallcorrected";
	}
}
