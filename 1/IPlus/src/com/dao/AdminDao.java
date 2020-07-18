package com.dao;

import com.entity.Admin;

public interface AdminDao {
	/**
	 * 管理员登录
	 * @param aid
	 * @param apwd
	 * @return
	 */
	public Admin login(int aid,String apwd);
	/**
	 * 根据id查找管理员
	 * @param aid
	 * @return
	 */
	public Admin findAdminById(int aid);
	/**
	 * 修改密码
	 * @param ad
	 */
	public void updateAdminPwd(Admin ad);
}
