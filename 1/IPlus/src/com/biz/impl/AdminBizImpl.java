package com.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biz.AdminBiz;
import com.dao.AdminDao;
import com.entity.Admin;
@Component("adminBiz")
public class AdminBizImpl implements AdminBiz {
	@Autowired
	private AdminDao adminDao;
	@Override
	public Admin login(int aid, String apwd) {
		Admin a=adminDao.login(aid, apwd);
		return a;
	}
	@Override
	public Admin findAdminById(int aid) {
		Admin a=adminDao.findAdminById(aid);
		return a;
	}
	@Override
	public void updateAdminPwd(Admin ad) {
		adminDao.updateAdminPwd(ad);
	}

}
