package com.dao;

import com.entity.Admin;

public interface AdminDao {
	/**
	 * ����Ա��¼
	 * @param aid
	 * @param apwd
	 * @return
	 */
	public Admin login(int aid,String apwd);
	/**
	 * ����id���ҹ���Ա
	 * @param aid
	 * @return
	 */
	public Admin findAdminById(int aid);
	/**
	 * �޸�����
	 * @param ad
	 */
	public void updateAdminPwd(Admin ad);
}