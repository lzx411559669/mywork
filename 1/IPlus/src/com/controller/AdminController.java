package com.controller;

import com.biz.AdminBiz;
import com.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin.do")
@Controller
public class AdminController {
	@Autowired
	private AdminBiz adminBiz;
	@RequestMapping(params="login")
	@ResponseBody
	public Admin login(HttpServletRequest request, HttpServletResponse response,Integer aid,String apwd){
		Admin ad=adminBiz.login(aid, apwd);
		HttpSession session=request.getSession();
		session.setAttribute("ad", ad);
		return ad;
	}
	@RequestMapping(params="findAdminById")
	@ResponseBody
	public Admin findAdminById(int aid){
		Admin a=adminBiz.findAdminById(aid);
		return a;
	}
	@RequestMapping(params="updateAdminPwd")
	public String updateAdminPwd(ModelMap map,Integer aid,String apwd){
		Admin ad=new Admin();
		ad.setAid(aid);
		ad.setApwd(apwd);
		adminBiz.updateAdminPwd(ad);
		return "adminlogin";
	}
}
